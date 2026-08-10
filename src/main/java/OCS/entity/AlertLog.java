package OCS.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import OCS.entity.Enum.AlertType;
import OCS.entity.Enum.DoctorResponse;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "alert_log")
public class AlertLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alertId;


    private Integer medicinePrescriptionId;


    private Integer doctorId;


    private Integer sessionId;


    @Enumerated(EnumType.STRING)
    private AlertType alertType;


    @Column(columnDefinition = "TEXT")
    private String alertMessage;


    @Enumerated(EnumType.STRING)
    private DoctorResponse doctorResponse;


    private LocalDateTime responseTime;


    private LocalDateTime createdAt;


}