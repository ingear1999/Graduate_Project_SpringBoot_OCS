package OCS.Service;

import java.time.LocalDateTime;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import OCS.DTO.RegistrationDTO;
import OCS.DTO.RespondDTO.RegistrationResponseDTO;
import OCS.Repository.DepartmentRepository;
import OCS.Repository.DoctorRepository;
import OCS.Repository.PatientInfo_repository;
import OCS.Repository.RegistrationRepository;
import OCS.entity.DepartmentEntity;
import OCS.entity.DoctorEntity;
import OCS.entity.PatientEntity;
import OCS.entity.RegistrationEntity;
import OCS.entity.Enum.RegistrationStatus;

@Service
@Transactional
public class RegistrationService {

    private final PatientInfo_repository patientRepository;
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;
    private final RegistrationRepository registrationRepository;

    public RegistrationService(
            PatientInfo_repository patientRepository,
            DoctorRepository doctorRepository,
            DepartmentRepository departmentRepository,
            RegistrationRepository registrationRepository) {

        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.departmentRepository = departmentRepository;
        this.registrationRepository = registrationRepository;
    }

    public RegistrationResponseDTO registration(
            RegistrationDTO dto) {

        // 1. Find patient
        PatientEntity patient =
                patientRepository.findById(
                        (int) dto.getPatientId()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Patient not found: "
                                + dto.getPatientId()
                        )
                );

        // 2. Find doctor
        DoctorEntity doctor =
                doctorRepository.findById(
                        (int) dto.getDoctorId()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Doctor not found: "
                                + dto.getDoctorId()
                        )
                );

        // 3. Find department
        DepartmentEntity department =
                departmentRepository.findById(
                        (int) dto.getDepartmentId()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Department not found: "
                                + dto.getDepartmentId()
                        )
                );

        // 4. Create registration
        RegistrationEntity registration =
                new RegistrationEntity();

        registration.setPatient(patient);
        registration.setDoctor(doctor);
        registration.setDepartment(department);

        registration.setDiagnosis(
                dto.getDiagnosis()
        );

        // Automatically set registration time
        registration.setRegistrationTime(
                LocalDateTime.now()
        );

        // Not treated yet
        registration.setTreatTime(null);

        // Automatically registered
        registration.setStatus(
                RegistrationStatus.REGISTERED
        );

        // 5. Save
        RegistrationEntity saved =
                registrationRepository.save(
                        registration
                );

        // 6. Create response
        RegistrationResponseDTO response =
                new RegistrationResponseDTO();

        response.setRegistrationcode(
                String.format(
                        "REG-%03d",
                        saved.getRegistrationId()
                )
        );

        response.setPatientName(
                saved.getPatient()
                     .getPatientName()
        );

        // Doctor name comes from Doctor -> Signup
        response.setDoctorName(
                saved.getDoctor()
                     .getSignup()
                     .getName()
        );

        response.setRegistrationStatus(
                saved.getStatus().name()
        );

        response.setDepartment(
                saved.getDepartment()
                     .getDepartmentName()
        );

        return response;
    }
    
    
    public List <RegistrationResponseDTO> checkRegistration(){
    	List<RegistrationResponseDTO> result = new ArrayList<>();
    	for(RegistrationEntity registration : registrationRepository.findAll()) {
    		RegistrationResponseDTO response = new RegistrationResponseDTO();
    		response.setRegistrationcode(String.format("REG-%03d",
    												registration.getRegistrationId())); 
    		//REG-%03d Make this number at least 3 digits long; if it's shorter, add zeros in front.
    		
    		response.setPatientName(registration.getPatient().getPatientName());
    		response.setDoctorName(registration.getDoctor().getSignup().getName());
    		response.setRegistrationStatus(registration.getStatus().name());
    		response.setDepartment(registration.getDepartment().getDepartmentName());
    		
    		result.add(response);
    	}
    	
    	return result;
    	
    }
}