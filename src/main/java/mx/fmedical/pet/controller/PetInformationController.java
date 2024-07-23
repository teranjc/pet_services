package mx.fmedical.pet.controller;

import jakarta.transaction.Transactional;
import mx.fmedical.pet.business.IPetInformationBusiness;
import mx.fmedical.pet.contollerUtil.contants.ControllerUtil;
import mx.fmedical.pet.models.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Hugo Gerardo Gonzalez Mendoza
 * @Date 17/07/2024 18:00
 * @Company Erillam Helthcare s. de r.l. de c.v.
 * @Project PET
 */

@RestController
@RequestMapping(ControllerUtil.CONTROLLER_PET_INFORMATION)
public class PetInformationController {
    @Autowired
    private IPetInformationBusiness petInformationBusiness;

    @Transactional
    @PostMapping(ControllerUtil.ADD_PET_INFORMATION)
    public ResponseEntity<?> saveConsultation(@RequestBody PetConsultationDTO petConsultationDTO) {
        PetInformationByIdDTO petInformationByIdDTO = petInformationBusiness.saveConsultation(petConsultationDTO);
        return new ResponseEntity<>(petInformationByIdDTO, HttpStatus.CREATED);
    }

    @Transactional
    @PostMapping(ControllerUtil.REPORT_PET_INFORMATION)
    public ResponseEntity<?> petInformationReport(@RequestBody PetInformationByIdDTO petInformationByIdDTO) {
        PetInformationReportDTO petInformationReport = petInformationBusiness.petInformationReport(petInformationByIdDTO.getIdPetInformation());
        return new ResponseEntity<>(petInformationReport, HttpStatus.CREATED);
    }


    @PostMapping(ControllerUtil.PAGINATION_PET_INFORMATION)
    public ResponseEntity<?> paginationPet(@RequestBody PaginationRequestDTO paginationRequestDTO) {
        int page = paginationRequestDTO.getPage();
        int size = paginationRequestDTO.getSize();
        String search = paginationRequestDTO.getSearch();

        Pageable pageable = PageRequest.of(page, size);

        Page<PaginationPetDTO> paginationPetDTOPage =
                petInformationBusiness.paginationPet(pageable, search);

        return ResponseEntity.ok(paginationPetDTOPage);
    }
}
