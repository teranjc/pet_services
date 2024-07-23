package mx.fmedical.pet.repository;

import mx.fmedical.pet.models.entities.VetAssigment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVetAssigmentRepository extends JpaRepository<VetAssigment, String> {
    @Query("SELECT v FROM VetAssigment v WHERE v.fullName LIKE %:search% OR v.professionalLicense LIKE %:search%")
    List<VetAssigment> findAllVetAssigned(@Param("search") String search);
}
