package OCS.DTO;

public class DepartmentDTO {


    private String departmentLocation;

    private String departmentName;


    public DepartmentDTO() {

    }


    public DepartmentDTO(String departmentLocation, String departmentName) {

        this.departmentLocation = departmentLocation;

        this.departmentName = departmentName;

    }


    public String getDepartmentLocation() {

        return departmentLocation;

    }


    public void setDepartmentLocation(String departmentLocation) {

        this.departmentLocation = departmentLocation;

    }


    public String getDepartmentName() {

        return departmentName;

    }


    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;

    }

}