package OCS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OCS.DTO.DoctorSignupDTO;
import OCS.DTO.RespondDTO.DoctorInfo;
import OCS.Service.DoctorSignUpService;

@RestController
@RequestMapping("/api/doctor-signups")
public class DoctorSignupController {

    private final DoctorSignUpService service;

    public DoctorSignupController(
            DoctorSignUpService service) {

        this.service = service;
    }

    // CREATE SIGNUP
    @PostMapping
    public ResponseEntity<DoctorInfo> createDoctorSignup(
            @RequestBody DoctorSignupDTO dto) {

        DoctorInfo response =
                service.createDoctorSignup(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // GET SIGNUP
    @GetMapping("/{id}")
    public ResponseEntity<DoctorInfo> getDoctorSignup(
            @PathVariable int id) {

        DoctorInfo response =
                service.getDoctorSignupById(id);

        return ResponseEntity.ok(response);
    }

    // UPDATE SIGNUP
    @PutMapping("/{id}")
    public ResponseEntity<DoctorInfo> updateDoctorSignup(
            @PathVariable int id,
            @RequestBody DoctorSignupDTO dto) {

        DoctorInfo response =
                service.updateDoctorSignup(id, dto);

        return ResponseEntity.ok(response);
    }

    // DELETE SIGNUP
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctorSignup(
            @PathVariable int id) {

        service.deleteDoctorSignup(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}