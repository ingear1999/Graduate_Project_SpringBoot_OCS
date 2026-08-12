package OCS.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "signup")
@Getter
@Setter
public class DoctorSignUpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "signup_id")
    private int id;

    @Column(name = "doctor_name")
    private String name;

    @Column(name = "doctor_date_of_birth")
    private LocalDate date;

    @Column(name = "doctor_username")
    private String username;

    @Column(name = "doctor_password")
    private String password;

    @Column(name = "doctor_address")
    private String address;
}