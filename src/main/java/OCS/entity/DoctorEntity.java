package OCS.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctor")
@Getter
@Setter
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private DepartmentEntity department;

    @OneToOne
    @JoinColumn(name = "signup_id", unique = true)
    private DoctorSignUpEntity signup;

    @OneToMany(mappedBy = "doctor")
    private List<RegistrationEntity> registrations;
}