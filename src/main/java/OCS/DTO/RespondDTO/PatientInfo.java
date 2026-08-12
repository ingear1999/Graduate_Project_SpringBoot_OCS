package OCS.DTO.RespondDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientInfo {

    private int patientId;
    private String patientName;
    private String gender;
    private int age;
}