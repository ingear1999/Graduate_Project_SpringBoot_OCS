package OCS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import OCS.entity.SessionLogEntity;

public interface SessionLogRepository
        extends JpaRepository<SessionLogEntity, Integer> {

    List<SessionLogEntity> findByDoctorId(
            int doctorId
    );
}