package OCS.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import OCS.DTO.RespondDTO.*;
import OCS.Service.SessionLogService;
import OCS.entity.SessionLogEntity;

@RestController
@RequestMapping("/api/sessions")
public class SessionLogController {

    private final SessionLogService service;


    public SessionLogController(
            SessionLogService service) {

        this.service = service;
    }


    // ==========================================
    // Start session
    // ==========================================

    @PostMapping
    public ResponseEntity<SessionLogEntity>
    startSession(
            @RequestBody SessionLogDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        service.startSession(dto)
                );
    }


    // ==========================================
    // End session
    // ==========================================

    @PutMapping("/{sessionId}/end")
    public ResponseEntity<SessionLogEntity>
    endSession(
            @PathVariable int sessionId) {

        return ResponseEntity.ok(
                service.endSession(
                        sessionId
                )
        );
    }


    // ==========================================
    // Get one session
    // ==========================================

    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionLogEntity>
    getSession(
            @PathVariable int sessionId) {

        return ResponseEntity.ok(
                service.getSession(
                        sessionId
                )
        );
    }


    // ==========================================
    // Get doctor's sessions
    // ==========================================

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<SessionLogEntity>>
    getDoctorSessions(
            @PathVariable int doctorId) {

        return ResponseEntity.ok(
                service.getDoctorSessions(
                        doctorId
                )
        );
    }
}