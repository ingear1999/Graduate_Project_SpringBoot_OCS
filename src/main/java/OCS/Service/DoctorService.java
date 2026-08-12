package OCS.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import OCS.DTO.DoctorCreateDTO;
import OCS.DTO.RespondDTO.DoctorInfo;
import OCS.Repository.DepartmentRepository;
import OCS.Repository.DoctorRepository;
import OCS.Repository.DoctorSignupRepository;
import OCS.entity.DepartmentEntity;
import OCS.entity.DoctorEntity;
import OCS.entity.DoctorSignUpEntity;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorSignupRepository signupRepository;
    private final DepartmentRepository departmentRepository;

    public DoctorService(
            DoctorRepository doctorRepository,
            DoctorSignupRepository signupRepository,
            DepartmentRepository departmentRepository) {

        this.doctorRepository = doctorRepository;
        this.signupRepository = signupRepository;
        this.departmentRepository = departmentRepository;
    }

    // CREATE ACTUAL DOCTOR
    public DoctorInfo createDoctor(DoctorCreateDTO dto) {

        // 1. Find signup account
        DoctorSignUpEntity signup =
                signupRepository.findById(dto.getSignupId())
                .orElseThrow(() ->
                    new RuntimeException(
                        "Doctor signup not found: "
                        + dto.getSignupId()
                    )
                );

        // 2. Find department
        DepartmentEntity department =
                departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() ->
                    new RuntimeException(
                        "Department not found: "
                        + dto.getDepartmentId()
                    )
                );

        // 3. Create doctor
        DoctorEntity doctor = new DoctorEntity();

        doctor.setSignup(signup);
        doctor.setDepartment(department);

        // 4. Save
        DoctorEntity savedDoctor =
                doctorRepository.save(doctor);

        // 5. Convert to response
        return toDoctorInfo(savedDoctor);
    }

    // GET ACTUAL DOCTOR
    @Transactional(readOnly = true)
    public DoctorInfo getDoctorById(int id) {

        DoctorEntity doctor =
                doctorRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Doctor not found: " + id
                    )
                );

        return toDoctorInfo(doctor);
    }

    // ENTITY -> DTO
    private DoctorInfo toDoctorInfo(
            DoctorEntity doctor) {

        DoctorInfo response = new DoctorInfo();

        response.setDoctorId(doctor.getId());

        if (doctor.getSignup() != null) {

            response.setSignupId(
                doctor.getSignup().getId()
            );

            response.setDoctorName(
                doctor.getSignup().getName()
            );

            response.setDateOfBirth(
                doctor.getSignup().getDate()
            );

            response.setUsername(
                doctor.getSignup().getUsername()
            );

            response.setAddress(
                doctor.getSignup().getAddress()
            );
        }

        if (doctor.getDepartment() != null) {

            response.setDepartmentId(
                doctor.getDepartment().getDepartmentId()
            );
        }

        return response;
    }
}