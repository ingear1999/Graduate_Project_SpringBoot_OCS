package OCS.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import OCS.DTO.MedicineDTO;
import OCS.Repository.MedicineRepository;
import OCS.entity.MedicineEntity;

@Service
@Transactional
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineService(
            MedicineRepository medicineRepository) {

        this.medicineRepository = medicineRepository;
    }

    public MedicineEntity createMedicine(MedicineDTO dto) {

        // 1. Create Entity
        MedicineEntity medicine = new MedicineEntity();

        // 2. Copy DTO data to Entity
        medicine.setClassification(
                dto.getClassification()
        );

        medicine.setMedicineName(
                dto.getMedicineName()
        );

        medicine.setMedicineComposition(
                dto.getMedicineComposition()
        );

        medicine.setMedicineType(
                dto.getMedicineType()
        );

        medicine.setTotalAmount(
                dto.getTotalAmount()
        );

        medicine.setStockCount(
                dto.getStockCount()
        );

        medicine.setNormalDoseMin(
                dto.getNormalDoseMin()
        );

        medicine.setNormalDoseMax(
                dto.getNormalDoseMax()
        );

        medicine.setUnit(
                dto.getUnit()
        );

        medicine.setAllowedRoutes(
                dto.getAllowedRoutes()
        );

        medicine.setHighRiskFlag(
                dto.isHighRiskFlag()
        );

        // 3. Save to database
        return medicineRepository.save(medicine);
    }
}