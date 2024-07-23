package mx.fmedical.pet.repository;

import mx.fmedical.pet.models.dto.PetDTO;
import mx.fmedical.pet.models.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPetRepository extends JpaRepository<Pet, String> {

    @Query("SELECT new mx.fmedical.pet.models.dto.PetDTO(" +
    "pet.idPet, pet.name, pet.species, pet.breed, pet.age, pet.weight, ownerInformation.idOwnerInformation, pet.sex, pet.color, pet.currentVaccination) " +
    "FROM Pet pet " +
    "INNER JOIN Sterilize sterilize on pet.idPet = sterilize.pet.idPet " +
    "INNER JOIN pet.ownerInformation ownerInformation " +
    "WHERE sterilize.idSterilize = :idSterilize")
    PetDTO findPetBySterilizeId(@Param("idSterilize") String idSterilize);
}
