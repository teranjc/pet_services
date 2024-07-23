package mx.fmedical.pet.repository;

import mx.fmedical.pet.models.dto.OwnerInformationDTO;
import mx.fmedical.pet.models.entities.OwnerInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOwnerInformationRepository extends JpaRepository<OwnerInformation, String> {

     @Query("SELECT new mx.fmedical.pet.models.dto.OwnerInformationDTO(" +
            "oi.fullName, oi.address, oi.phone, oi.age) " +
           "FROM OwnerInformation oi " +
           "INNER JOIN Pet p ON oi.idOwnerInformation = p.ownerInformation.idOwnerInformation " +
           "INNER JOIN Sterilize s ON p.idPet = s.pet.idPet " +
           "WHERE s.idSterilize = :idSterilize")
    OwnerInformationDTO findPetBySterilizeId(@Param("idSterilize") String idSterilize);
}