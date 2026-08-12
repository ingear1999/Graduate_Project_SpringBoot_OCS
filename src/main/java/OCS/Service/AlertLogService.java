package OCS.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import OCS.Repository.AlertLogRepository;
import OCS.entity.AlertLogEntity;
import OCS.entity.Enum.DoctorResponse;

@Service
@Transactional
public class AlertLogService {

    private final AlertLogRepository alertLogRepository;

    public AlertLogService(
            AlertLogRepository alertLogRepository) {

        this.alertLogRepository = alertLogRepository;
    }


    // ==========================================
    // 1. Get all alerts for a doctor
    // ==========================================

    public List<AlertLogEntity> getDoctorAlerts(
           int doctorId) {

        return alertLogRepository
                .findByDoctorId(doctorId);
    }


    // ==========================================
    // 2. Get alerts by response
    // ==========================================

    public List<AlertLogEntity> getAlertsByResponse(
            DoctorResponse response) {

        return alertLogRepository
                .findByDoctorResponse(response);
    }


    // ==========================================
    // 3. Get one alert
    // ==========================================

    public AlertLogEntity getAlert(
            int alertId) {

        return alertLogRepository
                .findById(alertId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Alert not found: "
                                + alertId
                        )
                );
    }


    // ==========================================
    // 4. Doctor responds to an alert
    // ==========================================

    public AlertLogEntity respondToAlert(
            int alertId,
            DoctorResponse response) {

        AlertLogEntity alert =
                alertLogRepository
                        .findById(alertId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Alert not found: "
                                        + alertId
                                )
                        );


        // Make sure the alert has not
        // already been handled

        if (alert.getDoctorResponse()
                != DoctorResponse.PENDING) {

            throw new RuntimeException(
                    "This alert has already been handled."
            );
        }


        // Set doctor's response

        alert.setDoctorResponse(
                response
        );


        // Record response time

        alert.setResponseTime(
                LocalDateTime.now()
        );


        return alertLogRepository.save(alert);
    }
}