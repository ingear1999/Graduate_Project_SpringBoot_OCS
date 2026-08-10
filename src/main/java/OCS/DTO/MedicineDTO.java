package OCS.DTO;

import java.math.BigDecimal;

public class MedicineDTO {

    private String classification;
    private String medicineName;
    private String medicineComposition;
    private String medicineType;

    private BigDecimal totalAmount;
    private int stockCount;

    private BigDecimal normalDoseMin;
    private BigDecimal normalDoseMax;

    private String unit;
    private String allowedRoutes;

    private boolean highRiskFlag;


    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }


    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }


    public String getMedicineComposition() {
        return medicineComposition;
    }

    public void setMedicineComposition(String medicineComposition) {
        this.medicineComposition = medicineComposition;
    }


    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }


    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }


    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }


    public BigDecimal getNormalDoseMin() {
        return normalDoseMin;
    }

    public void setNormalDoseMin(BigDecimal normalDoseMin) {
        this.normalDoseMin = normalDoseMin;
    }


    public BigDecimal getNormalDoseMax() {
        return normalDoseMax;
    }

    public void setNormalDoseMax(BigDecimal normalDoseMax) {
        this.normalDoseMax = normalDoseMax;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getAllowedRoutes() {
        return allowedRoutes;
    }

    public void setAllowedRoutes(String allowedRoutes) {
        this.allowedRoutes = allowedRoutes;
    }


    public boolean isHighRiskFlag() {
        return highRiskFlag;
    }

    public void setHighRiskFlag(boolean highRiskFlag) {
        this.highRiskFlag = highRiskFlag;
    }
}