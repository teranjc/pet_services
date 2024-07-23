package mx.fmedical.pet.repository;

import mx.fmedical.pet.models.dto.PaginationSterilizeDTO;
import mx.fmedical.pet.models.dto.SterilizeDTO;
import mx.fmedical.pet.models.entities.Sterilize;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISterilizeRepository extends JpaRepository<Sterilize, String> {

    @Query("SELECT new mx.fmedical.pet.models.dto.PaginationSterilizeDTO(" +
            "pet.name, ownerInformation.fullName, sterilize.registrationDate, sterilize.idSterilize) " +
            "FROM Sterilize sterilize " +
            "INNER JOIN sterilize.pet pet " +
            "INNER JOIN pet.ownerInformation ownerInformation " +
            "WHERE LOWER(pet.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(ownerInformation.fullName) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "ORDER BY sterilize.registrationDate DESC")
    Page<PaginationSterilizeDTO> paginationSterilize(Pageable pageable, @Param("search") String search);

    @Query("SELECT new mx.fmedical.pet.models.dto.SterilizeDTO(" +
            "sterilize.diffusion, sterilize.size, sterilize.institutionAssigment, sterilize.reason, sterilize.cause, " +
            "vet.idVetAssigment) " +
            "FROM Sterilize sterilize " +
            "INNER JOIN sterilize.vetAssigment vet " +
            "WHERE sterilize.idSterilize = :idSterilize")
    SterilizeDTO findByIdSterilize(@Param("idSterilize") String idSterilize);

}
