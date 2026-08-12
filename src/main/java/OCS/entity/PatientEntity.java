package OCS.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "gender")
    private String patientGender;

    @Column(name = "age")
    private int patientAge;

    @OneToMany(mappedBy = "patient")  //One patient can register many times:
    private List<RegistrationEntity> registrations;
}