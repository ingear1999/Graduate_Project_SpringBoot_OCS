package OCS.DTO;

import java.math.BigDecimal;

public class MedicinePrescriptionDTO {

    private int registrationId;

    private int medicineId;

    private int sessionId;

    private String medicineRemark;

    private int medicineTablet;

    private int medicineDivided;

    private int medicineDay;

    private BigDecimal dosage;

    private String route;

    private BigDecimal fatigueScoreAtOrder;


    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }


    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }


    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }


    public String getMedicineRemark() {
        return medicineRemark;
    }

    public void setMedicineRemark(String medicineRemark) {
        this.medicineRemark = medicineRemark;
    }


    public int getMedicineTablet() {
        return medicineTablet;
    }

    public void setMedicineTablet(int medicineTablet) {
        this.medicineTablet = medicineTablet;
    }


    public int getMedicineDivided() {
        return medicineDivided;
    }

    public void setMedicineDivided(int medicineDivided) {
        this.medicineDivided = medicineDivided;
    }


    public int getMedicineDay() {
        return medicineDay;
    }

    public void setMedicineDay(int medicineDay) {
        this.medicineDay = medicineDay;
    }


    public BigDecimal getDosage() {
        return dosage;
    }

    public void setDosage(BigDecimal dosage) {
        this.dosage = dosage;
    }


    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }


    public BigDecimal getFatigueScoreAtOrder() {
        return fatigueScoreAtOrder;
    }

    public void setFatigueScoreAtOrder(
            BigDecimal fatigueScoreAtOrder) {

        this.fatigueScoreAtOrder = fatigueScoreAtOrder;
    }
}