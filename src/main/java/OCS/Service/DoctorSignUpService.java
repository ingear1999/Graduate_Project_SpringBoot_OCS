package OCS.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import OCS.DTO.DoctorSignupDTO;
import OCS.DTO.RespondDTO.DoctorInfo;
import OCS.Repository.DoctorSignupRepository;
import OCS.entity.DoctorSignUpEntity;

@Service
@Transactional
public class DoctorSignUpService {

    private final DoctorSignupRepository repository;

    public DoctorSignUpService(DoctorSignupRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public DoctorInfo createDoctorSignup(DoctorSignupDTO dto) {

        DoctorSignUpEntity doctor = new DoctorSignUpEntity();

        doctor.setName(dto.getDoctorName());
        doctor.setDate(dto.getDateOfBirth());
        doctor.setUsername(dto.getUsername());
        doctor.setPassword(dto.getPassword());
        doctor.setAddress(dto.getAddress());

        DoctorSignUpEntity savedDoctor =
                repository.save(doctor);

        return toDoctorInfo(savedDoctor);
    }

    // GET ONE
    @Transactional(readOnly = true)
    public DoctorInfo getDoctorSignupById(int id) {

        DoctorSignUpEntity doctor =
                repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Doctor signup not found: " + id
                    )
                );

        return toDoctorInfo(doctor);
    }

    // UPDATE
    public DoctorInfo updateDoctorSignup(
            int id,
            DoctorSignupDTO dto) {

        DoctorSignUpEntity doctor =
                repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Doctor signup not found: " + id
                    )
                );

        doctor.setName(dto.getDoctorName());
        doctor.setDate(dto.getDateOfBirth());
        doctor.setUsername(dto.getUsername());
        doctor.setAddress(dto.getAddress());

        // Only update password when a new password is provided
        if (dto.getPassword() != null &&
            !dto.getPassword().isBlank()) {

            doctor.setPassword(dto.getPassword());
        }

        DoctorSignUpEntity updatedDoctor =
                repository.save(doctor);

        return toDoctorInfo(updatedDoctor);
    }

    // DELETE
    public void deleteDoctorSignup(int id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException(
                "Doctor signup not found: " + id
            );
        }

        repository.deleteById(id);
    }

    // ENTITY -> DTO
    private DoctorInfo toDoctorInfo(
            DoctorSignUpEntity doctor) {

        DoctorInfo response = new DoctorInfo();

        response.setSignupId(doctor.getId());

        response.setDoctorName(doctor.getName());
        response.setDateOfBirth(doctor.getDate());
        response.setUsername(doctor.getUsername());
        response.setAddress(doctor.getAddress());

        return response;
    }
}