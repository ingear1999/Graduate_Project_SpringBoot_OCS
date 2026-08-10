package OCS.DTO.RespondDTO;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PrescriptionInfo {


    private Integer prescriptionId;


    private Integer registrationId;


    private Integer medicineId;


    private String giveOutStatus;


    private String medicineRemark;


    private Integer medicineTablet;


    private Integer medicineDivided;


    private Integer medicineDay;


    private BigDecimal dosage;


    private String route;


    private LocalDateTime orderTime;


    private Integer sessionId;


    private BigDecimal fatigueScoreAtOrder;


}