package OCS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import OCS.entity.AlertLogEntity;
import OCS.entity.Enum.DoctorResponse;

public interface AlertLogRepository
        extends JpaRepository<AlertLogEntity, Integer> {

    List<AlertLogEntity> findByDoctorId(int doctorId);

    List<AlertLogEntity> findByDoctorResponse(
            DoctorResponse doctorResponse
    );
}