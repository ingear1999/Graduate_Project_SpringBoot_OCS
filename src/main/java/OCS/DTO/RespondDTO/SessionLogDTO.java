package OCS.DTO.RespondDTO;

public class SessionLogDTO {

    private int doctorId;

    private String sessionNote;

    private boolean nightShift;


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }


    public String getSessionNote() {
        return sessionNote;
    }

    public void setSessionNote(String sessionNote) {
        this.sessionNote = sessionNote;
    }


    public boolean isNightShift() {
        return nightShift;
    }

    public void setNightShift(boolean nightShift) {
        this.nightShift = nightShift;
    }
}