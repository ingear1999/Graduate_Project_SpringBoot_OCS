package OCS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import OCS.DTO.MedicinePrescriptionDTO;
import OCS.DTO.RespondDTO.PrescriptionInfo;
import OCS.Service.MedicinePrescriptionService;
import OCS.entity.MedicinePrescriptionEntity;
import OCS.entity.Enum.GiveOutStatus;

@RestController
@RequestMapping("/api/prescriptions")
public class MedicinePrescriptionController {

    private final MedicinePrescriptionService service;


    public MedicinePrescriptionController(
            MedicinePrescriptionService service) {

        this.service = service;
    }


    @PostMapping
    public ResponseEntity<MedicinePrescriptionEntity>
    createPrescription(
            @RequestBody MedicinePrescriptionDTO dto) {


        MedicinePrescriptionEntity prescription =
                service.createPrescription(dto);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(prescription);
    }
    
    @PutMapping
    public ResponseEntity<PrescriptionInfo> confirm_check(int id,GiveOutStatus status){
    	PrescriptionInfo prescription =
                service.updateGiveOutStatus(id, status);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(prescription);
    }
}