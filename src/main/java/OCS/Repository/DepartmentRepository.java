package OCS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OCS.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository 
        extends JpaRepository<DepartmentEntity, Integer> {
	
//Entity = DepartmentEntity
//Primary Key = Long (departmentId)
}