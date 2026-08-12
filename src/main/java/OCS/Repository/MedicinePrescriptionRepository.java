package OCS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import OCS.entity.MedicinePrescriptionEntity;

public interface MedicinePrescriptionRepository
        extends JpaRepository<MedicinePrescriptionEntity, Integer> {

}