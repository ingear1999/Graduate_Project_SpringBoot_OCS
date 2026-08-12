package OCS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import OCS.DTO.MedicineDTO;
import OCS.Service.MedicineService;
import OCS.entity.MedicineEntity;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService service;

    public MedicineController(
            MedicineService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MedicineEntity> createMedicine(
            @RequestBody MedicineDTO dto) {

        MedicineEntity medicine =
                service.createMedicine(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(medicine);
    }
}