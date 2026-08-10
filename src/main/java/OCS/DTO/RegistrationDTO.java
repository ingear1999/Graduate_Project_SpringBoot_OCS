package OCS.DTO;

import java.time.LocalDateTime;

public class RegistrationDTO {

    private int patientId;
    private int departmentId;
    private int doctorId;

    private String diagnosis;

    private LocalDateTime registrationTime;

    private LocalDateTime treatTime;

    private String status;


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }


    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }


    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }


    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }


    public LocalDateTime getTreatTime() {
        return treatTime;
    }

    public void setTreatTime(LocalDateTime treatTime) {
        this.treatTime = treatTime;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}