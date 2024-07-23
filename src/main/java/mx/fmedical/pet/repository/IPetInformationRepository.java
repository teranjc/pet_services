package mx.fmedical.pet.repository;


import mx.fmedical.pet.models.dto.PaginationPetDTO;
import mx.fmedical.pet.models.dto.PetConsultationDTO;
import mx.fmedical.pet.models.dto.PetInformationReportDTO;
import mx.fmedical.pet.models.entities.PetInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPetInformationRepository extends JpaRepository<PetInformation, String> {
    @Query("SELECT new mx.fmedical.pet.models.dto.PaginationPetDTO(pet.name, ownerInformation.fullName, pi.registrationDate, pi.idPetInformation) " +
            "FROM PetInformation pi " +
            "JOIN pi.pet pet " +
            "JOIN pet.ownerInformation ownerInformation " +
            "WHERE LOWER(pet.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(ownerInformation.fullName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "ORDER BY pi.registrationDate DESC")
    Page<PaginationPetDTO> paginationPet(@Param("search") String search, Pageable pageable);


    @Query("SELECT new mx.fmedical.pet.models.dto.PetInformationReportDTO(ownerInformation.fullName, ownerInformation.address, " +
            "ownerInformation.phone, pet.name, pet.species, pet.breed, pet.age, pet.weight, pi.reasonConsultation, pi.directInterrogation, pi.levelAttention, " +
            "pi.behavior, pi.march, pi.nutritionalCondition, pi.fr, pi.fc, pi.temp, pi.trc, pi.diagnostic, pi.treatment, pi.hydration, pi.observation, pi.registrationDate, " +
            "vet.name, vet.lastName, vet.professionalLicense) " +
            "FROM PetInformation pi " +
            "JOIN pi.pet pet " +
            "JOIN pet.ownerInformation ownerInformation " +
            "JOIN pi.vetAssigment vet " +
            "WHERE pi.idPetInformation = :idPetInformation")
    PetInformationReportDTO petInformationReport(@Param("idPetInformation") String idPetInformation);

}
