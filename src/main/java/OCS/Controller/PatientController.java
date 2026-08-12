package OCS.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import OCS.DTO.PatientDTO;
import OCS.DTO.RespondDTO.PatientInfo;
import OCS.Service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<PatientInfo> createPatient(
            @RequestBody PatientDTO dto) {

        return ResponseEntity.ok(
                patientService.createPatient(dto)
        );
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<PatientInfo>> getAllPatients() {

        return ResponseEntity.ok(
                patientService.getAllPatients()
        );
    }

    // GET ONE
    @GetMapping("/{id}")
    public ResponseEntity<PatientInfo> getPatientById(
            @PathVariable int id) {

        return ResponseEntity.ok(
                patientService.getPatientById(id)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(
            @PathVariable int id) {

        patientService.deletePatient(id);

        return ResponseEntity.noContent().build();
    }
}