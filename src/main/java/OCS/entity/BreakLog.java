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
@Table(name = "break_log")
public class BreakLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer breakId;


    @Column(nullable = false)
    private Integer sessionId;


    @Column(nullable = false)
    private Integer doctorId;


    private LocalDateTime breakStart;


    private LocalDateTime breakEnd;


    private Integer breakDurationMin = 0;

}