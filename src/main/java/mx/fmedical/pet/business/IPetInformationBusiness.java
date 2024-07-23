package mx.fmedical.pet.business;

import jakarta.transaction.Transactional;
import mx.fmedical.pet.models.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPetInformationBusiness {
    @Transactional
    PetInformationByIdDTO saveConsultation(PetConsultationDTO petConsultationDTO);

    Page<PaginationPetDTO> paginationPet(Pageable pageable, String search);

    PetInformationReportDTO petInformationReport(String idPetInformation);
}
