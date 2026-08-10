package OCS.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "session_log")
public class SessionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sessionId;


    // Foreign Key
    @Column(name = "doctor_id", nullable = false)
    private Integer doctorId;


    private LocalDateTime loginTime;


    private LocalDateTime logoutTime;


    private Double workingHours;


    private String sessionNote;


    private Boolean isNightShift = false;


    private Double orderPerHour;

}