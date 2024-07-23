package mx.fmedical.pet.repository;

import mx.fmedical.pet.models.dto.TreatmentDTO;
import mx.fmedical.pet.models.entities.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITreatmentRepository extends JpaRepository<Treatment, Long> {

    @Query("SELECT new mx.fmedical.pet.models.dto.TreatmentDTO(" +
            "treatment.percent, treatment.lotNumber, treatment.dateExpiry, treatment.dosage, treatment.nameTreatment, treatment.antibiotic, treatment.other) " +
            "FROM Treatment treatment " +
            "WHERE treatment.sterilize.idSterilize = :idSterilize")
    List<TreatmentDTO> findTreatmentsBySterilizeId(@Param("idSterilize") String idSterilize);
}
