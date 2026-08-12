package OCS.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "session_log")
@Getter
@Setter
public class SessionLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private int sessionId;


    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;


    @Column(name = "login_time")
    private LocalDateTime loginTime;


    @Column(name = "logout_time")
    private LocalDateTime logoutTime;


    @Column(name = "working_hours")
    private BigDecimal workingHours;


    @Column(name = "session_note")
    private String sessionNote;


    @Column(name = "is_night_shift")
    private boolean nightShift;


    @Column(name = "order_per_hour")
    private BigDecimal orderPerHour;
}