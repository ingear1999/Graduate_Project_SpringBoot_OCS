package OCS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OCS.DTO.DoctorCreateDTO;
import OCS.DTO.RespondDTO.DoctorInfo;
import OCS.Service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    // CREATE ACTUAL DOCTOR
    @PostMapping
    public ResponseEntity<DoctorInfo> createDoctor(
            @RequestBody DoctorCreateDTO dto) {

        DoctorInfo response =
                service.createDoctor(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // GET ACTUAL DOCTOR
    @GetMapping("/{id}")
    public ResponseEntity<DoctorInfo> getDoctor(
            @PathVariable int id) {

        DoctorInfo response =
                service.getDoctorById(id);

        return ResponseEntity.ok(response);
    }
}