package OCS.DTO.RespondDTO;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import OCS.entity.RegistrationEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PrescriptionInfo {


    private int prescriptionId;


    private int registrationId;


    private int medicineId;


    private Enum giveOutStatus;


    private String medicineRemark;


    private int medicineTablet;


    private int medicineDivided;


    private int medicineDay;


    private BigDecimal dosage;


    private String route;


    private LocalDateTime orderTime;


    private int sessionId;


    private BigDecimal fatigueScoreAtOrder;


}