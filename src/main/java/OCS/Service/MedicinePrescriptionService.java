package OCS.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import OCS.DTO.MedicinePrescriptionDTO;
import OCS.DTO.RespondDTO.PrescriptionInfo;
import OCS.Repository.AlertLogRepository;
import OCS.Repository.MedicinePrescriptionRepository;
import OCS.Repository.MedicineRepository;
import OCS.Repository.RegistrationRepository;
import OCS.Repository.SessionLogRepository;
import OCS.entity.AlertLogEntity;
import OCS.entity.MedicineEntity;
import OCS.entity.MedicinePrescriptionEntity;
import OCS.entity.RegistrationEntity;
import OCS.entity.SessionLogEntity;
import OCS.entity.Enum.AlertType;
import OCS.entity.Enum.DoctorResponse;
import OCS.entity.Enum.GiveOutStatus;

@Service
@Transactional
public class MedicinePrescriptionService {

    private final MedicinePrescriptionRepository prescriptionRepository;

    private final MedicineRepository medicineRepository;

    private final RegistrationRepository registrationRepository;

    private final SessionLogRepository sessionLogRepository;
    
    private final AlertLogRepository alertLogRepository;


    public MedicinePrescriptionService(
            MedicinePrescriptionRepository prescriptionRepository,
            MedicineRepository medicineRepository,
            RegistrationRepository registrationRepository,
            SessionLogRepository sessionLogRepository,
            AlertLogRepository alertLogRepository) {

        this.prescriptionRepository = prescriptionRepository;
        this.medicineRepository = medicineRepository;
        this.registrationRepository = registrationRepository;
        this.sessionLogRepository = sessionLogRepository;
        this.alertLogRepository = alertLogRepository;
    }

    
    private void createAlert(
            MedicinePrescriptionEntity prescription,
            SessionLogEntity session,
            AlertType alertType,
            String message) {

        AlertLogEntity alert =
                new AlertLogEntity();

        alert.setMedicinePrescription(
                prescription
        );

        alert.setDoctor(
                session.getDoctor()
        );

        alert.setSession(
                session
        );

        alert.setAlertType(
                alertType
        );

        alert.setAlertMessage(
                message
        );

        // Doctor has not responded yet
     // Doctor has not responded yet
        alert.setDoctorResponse(
                DoctorResponse.PENDING
        );

        alert.setResponseTime(null);

        alert.setCreatedAt(
                LocalDateTime.now()
        );

        alertLogRepository.save(alert);
    }

    public MedicinePrescriptionEntity createPrescription(
            MedicinePrescriptionDTO dto) {


        // 1. Find registration

        RegistrationEntity registration =
                registrationRepository.findById(
                        dto.getRegistrationId()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Registration not found: "
                                + dto.getRegistrationId()
                        )
                );


        // 2. Find medicine

        MedicineEntity medicine =
                medicineRepository.findById(
                        dto.getMedicineId()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Medicine not found: "
                                + dto.getMedicineId()
                        )
                );


        // 3. Find doctor session

        SessionLogEntity session =
                sessionLogRepository.findById(
                        dto.getSessionId()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Session not found: "
                                + dto.getSessionId()
                        )
                );


        // 4. Create prescription

        MedicinePrescriptionEntity prescription =
                new MedicinePrescriptionEntity();


        prescription.setRegistration(registration);

        prescription.setMedicine(medicine);

        prescription.setSession(session);


        prescription.setMedicineRemark(
                dto.getMedicineRemark()
        );


        prescription.setMedicineTablet(
                dto.getMedicineTablet()
        );


        prescription.setMedicineDivided(
                dto.getMedicineDivided()
        );


        prescription.setMedicineDay(
                dto.getMedicineDay()
        );


        prescription.setDosage(
                dto.getDosage()
        );


        prescription.setRoute(
                dto.getRoute()
        );


        prescription.setFatigueScoreAtOrder(
                dto.getFatigueScoreAtOrder()
        );


        // Automatically set

        prescription.setGiveOutStatus(
                GiveOutStatus.PENDING
        );


        prescription.setOrderTime(
                LocalDateTime.now()
        );


        // 5. Save
        MedicinePrescriptionEntity saved =
                prescriptionRepository.save(prescription);
        
        if (dto.getDosage() != null
                && medicine.getNormalDoseMin() != null
                && dto.getDosage()
                       .compareTo(medicine.getNormalDoseMin()) < 0) {

            createAlert(
                    saved,
                    session,
                    AlertType.DOSAGE_OUTLIER,
                    "Dosage is below the normal minimum dose."
            );
        }


        if (dto.getDosage() != null
                && medicine.getNormalDoseMax() != null
                && dto.getDosage()
                       .compareTo(medicine.getNormalDoseMax()) > 0) {

            createAlert(
                    saved,
                    session,
                    AlertType.DOSAGE_OUTLIER,
                    "Dosage exceeds the normal maximum dose."
            );
        }
        
        String allowedRoutes =
                medicine.getAllowedRoutes();

        String requestedRoute =
                dto.getRoute();

        if (allowedRoutes != null
                && requestedRoute != null) {

            boolean routeAllowed =
                    false;

            String[] routes =
                    allowedRoutes.split(",");

            for (String route : routes) {

                if (route.trim()
                        .equalsIgnoreCase(requestedRoute.trim())) {

                    routeAllowed = true;
                    break;
                }
            }

            if (!routeAllowed) {

                createAlert(
                        saved,
                        session,
                        AlertType.WRONG_ROUTE,
                        "The prescribed route is not allowed for this medicine."
                );
            }
        }
        
        if (medicine.isHighRiskFlag()) {

            createAlert(
                    saved,
                    session,
                    AlertType.HIGH_RISK_DRUG,
                    "This medicine is classified as high risk."
            );
        }

        return  saved;
    }
    
    public PrescriptionInfo updateGiveOutStatus(
            int prescriptionId,
            GiveOutStatus status) {

        MedicinePrescriptionEntity entity =
                prescriptionRepository.findById(prescriptionId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Prescription not found: "
                                        + prescriptionId
                                )
                        );

        entity.setGiveOutStatus(status);

        MedicinePrescriptionEntity saved =
                prescriptionRepository.save(entity);

        PrescriptionInfo info = new PrescriptionInfo();

        info.setPrescriptionId(
                saved.getMedicinePrescriptionId()
        );

        info.setFatigueScoreAtOrder(
                saved.getFatigueScoreAtOrder()
        );

        info.setDosage(
                saved.getDosage()
        );

        info.setMedicineDivided(
                saved.getMedicineDivided()
        );

        info.setMedicineRemark(
                saved.getMedicineRemark()
        );

        info.setMedicineTablet(
                saved.getMedicineTablet()
        );

        info.setRoute(
                saved.getRoute()
        );

        info.setOrderTime(
                saved.getOrderTime()
        );

        info.setGiveOutStatus(
                saved.getGiveOutStatus()
        );

        return info;
    }
}