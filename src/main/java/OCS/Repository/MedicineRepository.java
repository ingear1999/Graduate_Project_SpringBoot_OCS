package OCS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import OCS.entity.MedicineEntity;

public interface MedicineRepository
        extends JpaRepository<MedicineEntity, Integer> {

}