package OCS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import OCS.entity.PatientEntity;

public interface PatientInfo_repository extends JpaRepository<PatientEntity,Integer>{

}
