package OCS.DTO.RespondDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponseDTO {

	private String registrationcode;
	
    private String patientName;

    private String doctorName;

    private String registrationStatus;

    private String department;
}