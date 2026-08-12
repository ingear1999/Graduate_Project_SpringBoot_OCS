package OCS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import OCS.entity.DoctorSignUpEntity;

public interface DoctorSignupRepository extends JpaRepository<DoctorSignUpEntity, Integer >{

}
