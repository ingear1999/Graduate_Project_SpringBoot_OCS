package OCS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import OCS.entity.DoctorEntity;
import OCS.entity.DoctorSignUpEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity , Integer >{

}
