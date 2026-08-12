package OCS.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import OCS.entity.Enum.RegistrationStatus;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "registration")

@Getter
@Setter
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private int registrationId;

    @ManyToOne
    
//    Registration 1 ──┐
//    Registration 2 ──┼──> Patient
//    Registration 3 ──┘
    
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private DepartmentEntity department;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "registration_time")
    private LocalDateTime registrationTime;

    @Column(name = "treat_time")
    private LocalDateTime treatTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RegistrationStatus status;

    
}