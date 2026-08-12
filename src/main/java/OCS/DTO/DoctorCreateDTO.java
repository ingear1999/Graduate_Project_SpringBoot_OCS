package OCS.DTO;

public class DoctorCreateDTO {

    private int signupId;
    private int departmentId;

    public int getSignupId() {
        return signupId;
    }

    public void setSignupId(int signupId) {
        this.signupId = signupId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}