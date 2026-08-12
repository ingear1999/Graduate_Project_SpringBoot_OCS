package OCS.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import OCS.entity.Enum.AlertType;
import OCS.entity.Enum.DoctorResponse;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alert_log")
@Getter
@Setter
public class AlertLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private int alertId;


    @ManyToOne
    @JoinColumn(
        name = "medicine_prescription_id",
        nullable = false
    )
    private MedicinePrescriptionEntity medicinePrescription;


    @ManyToOne
    @JoinColumn(
        name = "doctor_id",
        nullable = false
    )
    private DoctorEntity doctor;


    @ManyToOne
    @JoinColumn(
        name = "session_id",
        nullable = false
    )
    private SessionLogEntity session;


    @Enumerated(EnumType.STRING)
    @Column(name = "alert_type", nullable = false)
    private AlertType alertType;


    @Column(name = "alert_message", nullable = false)
    private String alertMessage;


    @Enumerated(EnumType.STRING)
    @Column(name = "doctor_response", nullable = false)
    private DoctorResponse doctorResponse;


    @Column(name = "response_time")
    private LocalDateTime responseTime;


    @Column(name = "created_at")
    private LocalDateTime createdAt;
}