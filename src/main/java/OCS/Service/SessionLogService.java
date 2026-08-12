package OCS.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import OCS.DTO.RespondDTO.*;
import OCS.Repository.DoctorRepository;
import OCS.Repository.SessionLogRepository;
import OCS.entity.DoctorEntity;
import OCS.entity.SessionLogEntity;

@Service
@Transactional
public class SessionLogService {

    private final SessionLogRepository sessionLogRepository;

    private final DoctorRepository doctorRepository;


    public SessionLogService(
            SessionLogRepository sessionLogRepository,
            DoctorRepository doctorRepository) {

        this.sessionLogRepository = sessionLogRepository;
        this.doctorRepository = doctorRepository;
    }


    // ==========================================
    // 1. Start doctor session
    // ==========================================

    public SessionLogEntity startSession(
            SessionLogDTO dto) {

        // Find doctor

        DoctorEntity doctor =
                doctorRepository.findById(
                        (int) dto.getDoctorId()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Doctor not found: "
                                + dto.getDoctorId()
                        )
                );


        // Create session

        SessionLogEntity session =
                new SessionLogEntity();


        session.setDoctor(doctor);


        // Automatically record login time

        session.setLoginTime(
                LocalDateTime.now()
        );


        // Not logged out yet

        session.setLogoutTime(null);


        session.setSessionNote(
                dto.getSessionNote()
        );


        session.setNightShift(
                dto.isNightShift()
        );


        // Initial values

        session.setWorkingHours(
                BigDecimal.ZERO
        );

        session.setOrderPerHour(
                BigDecimal.ZERO
        );


        return sessionLogRepository.save(session);
    }


    // ==========================================
    // 2. End doctor session
    // ==========================================

    public SessionLogEntity endSession(
            int sessionId) {

        SessionLogEntity session =
                sessionLogRepository
                        .findById(sessionId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Session not found: "
                                        + sessionId
                                )
                        );


        // Make sure session isn't already closed

        if (session.getLogoutTime() != null) {

            throw new RuntimeException(
                    "This session has already ended."
            );
        }


        // Record logout time

        LocalDateTime logoutTime =
                LocalDateTime.now();

        session.setLogoutTime(
                logoutTime
        );


        // Calculate working hours

        Duration duration =
                Duration.between(
                        session.getLoginTime(),
                        logoutTime
                );


        BigDecimal workingHours =
                BigDecimal.valueOf(
                        duration.toMinutes()
                )
                .divide(
                        BigDecimal.valueOf(60),
                        2,
                        java.math.RoundingMode.HALF_UP
                );


        session.setWorkingHours(
                workingHours
        );


        return sessionLogRepository.save(session);
    }


    // ==========================================
    // 3. Get one session
    // ==========================================

    public SessionLogEntity getSession(
            int sessionId) {

        return sessionLogRepository
                .findById(sessionId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Session not found: "
                                + sessionId
                        )
                );
    }


    // ==========================================
    // 4. Get all sessions for doctor
    // ==========================================

    public List<SessionLogEntity> getDoctorSessions(
            int doctorId) {

        return sessionLogRepository
                .findByDoctorId(
                        doctorId
                );
    }
}