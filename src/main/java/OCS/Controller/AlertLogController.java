package OCS.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import OCS.Service.AlertLogService;
import OCS.entity.AlertLogEntity;
import OCS.entity.Enum.DoctorResponse;

@RestController
@RequestMapping("/api/alerts")
public class AlertLogController {

    private final AlertLogService service;


    public AlertLogController(
            AlertLogService service) {

        this.service = service;
    }


    // ==========================================
    // Get all alerts for doctor
    // ==========================================

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AlertLogEntity>>
    getDoctorAlerts(
            @PathVariable int doctorId) {

        return ResponseEntity.ok(
                service.getDoctorAlerts(
                        doctorId
                )
        );
    }


    // ==========================================
    // Get alerts by response
    // ==========================================

    @GetMapping("/response/{response}")
    public ResponseEntity<List<AlertLogEntity>>
    getAlertsByResponse(
            @PathVariable DoctorResponse response) {

        return ResponseEntity.ok(
                service.getAlertsByResponse(
                        response
                )
        );
    }


    // ==========================================
    // Get one alert
    // ==========================================

    @GetMapping("/{alertId}")
    public ResponseEntity<AlertLogEntity>
    getAlert(
            @PathVariable int alertId) {

        return ResponseEntity.ok(
                service.getAlert(alertId)
        );
    }


    // ==========================================
    // Doctor responds to alert
    // ==========================================

    @PutMapping("/{alertId}/response")
    public ResponseEntity<AlertLogEntity>
    respondToAlert(
            @PathVariable int alertId,
            @RequestParam DoctorResponse response) {

        return ResponseEntity.ok(
                service.respondToAlert(
                        alertId,
                        response
                )
        );
    }
}