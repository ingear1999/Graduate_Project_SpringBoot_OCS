package OCS.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicine")
@Getter
@Setter
public class MedicineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "classification", nullable = false)
    private String classification;

    @Column(name = "medicine_name", nullable = false)
    private String medicineName;

    @Column(name = "medicine_composition")
    private String medicineComposition;

    @Column(name = "medicine_type")
    private String medicineType;

    @Column(name = "total_amount", precision = 10, scale = 3)
    private BigDecimal totalAmount;

    @Column(name = "stock_count")
    private int stockCount;

    @Column(name = "normal_dose_min", precision = 10, scale = 3)
    private BigDecimal normalDoseMin;

    @Column(name = "normal_dose_max", precision = 10, scale = 3)
    private BigDecimal normalDoseMax;

    @Column(name = "unit")
    private String unit;

    @Column(name = "allowed_routes")
    private String allowedRoutes;

    @Column(name = "high_risk_flag")
    private boolean highRiskFlag;
}