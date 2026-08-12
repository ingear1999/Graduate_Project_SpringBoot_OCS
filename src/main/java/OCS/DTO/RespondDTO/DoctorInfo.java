package OCS.DTO.RespondDTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorInfo {

    private int doctorId;
    private int signupId;
    private int departmentId;

    private String doctorName;
    private LocalDate dateOfBirth;
    private String username;
    private String address;
}