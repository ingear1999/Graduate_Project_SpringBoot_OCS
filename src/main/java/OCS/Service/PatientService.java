package OCS.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import OCS.DTO.PatientDTO;
import OCS.DTO.RespondDTO.PatientInfo;
import OCS.Repository.PatientInfo_repository;
import OCS.entity.PatientEntity;

@Service
@Transactional
public class PatientService {

    private final PatientInfo_repository patientRepository;

    public PatientService(PatientInfo_repository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Create patient
    public PatientInfo createPatient(PatientDTO dto) {

        PatientEntity patient = new PatientEntity();

        patient.setPatientName(dto.getPatient_name());
        patient.setPatientGender(dto.getGender());
        patient.setPatientAge(dto.getAge());

        PatientEntity savedPatient = patientRepository.save(patient);

        return toPatientInfo(savedPatient);
    }

    // Get all patients
    @Transactional(readOnly = true)
    public List<PatientInfo> getAllPatients() {

        return patientRepository.findAll()
                .stream()
                .map(this::toPatientInfo)
                .collect(Collectors.toList());
    }

    // Get one patient
    @Transactional(readOnly = true)
    public PatientInfo getPatientById(int id) {

        PatientEntity patient = patientRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Patient not found: " + id)
                );

        return toPatientInfo(patient);
    }

    // Delete patient
    public void deletePatient(int id) {

        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found: " + id);
        }

        patientRepository.deleteById(id);
    }

    // Entity → Response DTO
    private PatientInfo toPatientInfo(PatientEntity patient) {

        PatientInfo response = new PatientInfo();

        response.setPatientId((int) patient.getPatientId());
        response.setPatientName(patient.getPatientName());
        response.setGender(patient.getPatientGender());
        response.setAge(patient.getPatientAge());

        return response;
    }
}