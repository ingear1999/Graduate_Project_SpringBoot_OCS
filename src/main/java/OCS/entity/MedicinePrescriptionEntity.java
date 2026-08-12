package OCS.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import OCS.entity.Enum.GiveOutStatus;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicine_prescription")
@Getter
@Setter
public class MedicinePrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_prescription_id")
    private int medicinePrescriptionId;


    @ManyToOne
    @JoinColumn(name = "registration_id", nullable = false)
    private RegistrationEntity registration;


    @ManyToOne
    @JoinColumn(name = "medicine_id", nullable = false)
    private MedicineEntity medicine;


    @Enumerated(EnumType.STRING)
    @Column(name = "give_out_status")
    private GiveOutStatus giveOutStatus;


    @Column(name = "medicine_remark")
    private String medicineRemark;


    @Column(name = "medicine_tablet")
    private int medicineTablet;


    @Column(name = "medicine_divided")
    private int medicineDivided;


    @Column(name = "medicine_day")
    private int medicineDay;


    @Column(name = "dosage")
    private BigDecimal dosage;


    @Column(name = "route")
    private String route;


    @Column(name = "order_time")
    private LocalDateTime orderTime;


    @ManyToOne
    @JoinColumn(name = "session_id")
    private SessionLogEntity session;


    @Column(name = "fatigue_score_at_order")
    private BigDecimal fatigueScoreAtOrder;
}