package OCS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OCS.entity.RegistrationEntity;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Integer> {

}