package OCS.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OCS.DTO.RegistrationDTO;
import OCS.DTO.RespondDTO.RegistrationResponseDTO;
import OCS.Service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(
            RegistrationService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RegistrationResponseDTO> registration(
            @RequestBody RegistrationDTO dto) {

        RegistrationResponseDTO response =
                service.registration(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    
    @GetMapping
    public List<RegistrationResponseDTO> checkRegistration() {
        return service.checkRegistration();
    }
}