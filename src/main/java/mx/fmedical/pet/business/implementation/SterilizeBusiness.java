package mx.fmedical.pet.business.implementation;

import jakarta.transaction.Transactional;
import mx.fmedical.pet.business.ISterilizeBusiness;
import mx.fmedical.pet.models.dto.*;
import mx.fmedical.pet.models.entities.*;
import mx.fmedical.pet.models.mapper.IOwnerInformationMapper;
import mx.fmedical.pet.models.mapper.IPetMapper;
import mx.fmedical.pet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class SterilizeBusiness implements ISterilizeBusiness {
    @Autowired
    private IOwnerInformationMapper iOwnerInformationMapper;

    @Autowired
    private IPetMapper iPetMapper;

    @Autowired
    private IOwnerInformationRepository ownerInformationRepository;

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private IVetAssigmentRepository iVetAssigmentRepository;

    @Autowired
    private ISterilizeRepository iSterilizeRepository;

    @Autowired
    private ITreatmentRepository iTreatmentRepository;


    @Transactional
    @Override
    public SteriliazeByIdDTO saveSterilize(SterilizeAddDTO sterilizeAddDTO) {

        OwnerInformation ownerInformation;
        ownerInformation = iOwnerInformationMapper.addOwnerInformation(sterilizeAddDTO.getOwnerInformationDTO());
        ownerInformationRepository.save(ownerInformation);

        Pet pet;
        pet = iPetMapper.toPet(sterilizeAddDTO.getPetDTO());
        pet.setOwnerInformation(ownerInformation);
        petRepository.save(pet);

        VetAssigment vetAssigment = iVetAssigmentRepository.findById(sterilizeAddDTO.getIdVetAssigment())
                .orElseThrow(() -> new RuntimeException("Vet assignment not found for ID: " + sterilizeAddDTO.getIdVetAssigment()));

        Sterilize sterilize = new Sterilize();
        sterilize.setDiffusion(sterilizeAddDTO.getDiffusion());

        sterilize.setSize(sterilizeAddDTO.getSize());
        sterilize.setInstitutionAssigment(sterilizeAddDTO.getInstitutionAssigment());
        sterilize.setReason(sterilizeAddDTO.getReason());
        sterilize.setCause(sterilizeAddDTO.getCause());
        sterilize.setType(2);
        sterilize.setRegistrationDate(Timestamp.from(Instant.now()));
        sterilize.setVetAssigment(vetAssigment);
        sterilize.setPet(pet);
        iSterilizeRepository.save(sterilize);
        // Save Treatments
        for (TreatmentDTO treatmentDTO : sterilizeAddDTO.getTreatmentDTO()) {
            Treatment treatment = new Treatment();
            treatment.setPercent(treatmentDTO.getPercent());
            treatment.setLotNumber(treatmentDTO.getLotNumber());
            treatment.setDateExpiry(treatmentDTO.getDateExpiry());
            treatment.setDosage(treatmentDTO.getDosage());
            treatment.setNameTreatment(treatmentDTO.getNameTreatment());
            treatment.setSterilize(sterilize);
            treatment.setOther(treatmentDTO.getOther());
            treatment.setAntibiotic(treatmentDTO.getAntibiotic());
            iTreatmentRepository.save(treatment);
        }

        // Create Response DTO
        SteriliazeByIdDTO sterilizeByIdDTO = new SteriliazeByIdDTO();
        sterilizeByIdDTO.setIdSteriliaze(sterilize.getIdSterilize());

        return sterilizeByIdDTO;
    }

    @Override
    public Page<PaginationSterilizeDTO> paginationSterilize(Pageable pageable, String search) {

        return iSterilizeRepository.paginationSterilize(pageable, search);
    }

    @Override
    public SterilizeReportDTO sterilizeInformationReport(String idSteriliaze) {
        PetDTO petDTO = petRepository.findPetBySterilizeId(idSteriliaze);
        System.out.println("petDTO: " + petDTO.toString());

        OwnerInformationDTO ownerInformationDTO = ownerInformationRepository.findPetBySterilizeId(idSteriliaze);
        System.out.println("owner;"+ownerInformationDTO.toString());

        SterilizeDTO sterilizeDTO = iSterilizeRepository.findByIdSterilize(idSteriliaze);

        List<TreatmentDTO> treatments = iTreatmentRepository.findTreatmentsBySterilizeId(idSteriliaze);
        SterilizeReportDTO sterilizeReportDTO = new SterilizeReportDTO();
        // Obtener los tratamientos asociados al reporte de esterilización


        sterilizeReportDTO.setOwnerInformationDTO(ownerInformationDTO);
        sterilizeReportDTO.setPetDTO(petDTO);
        sterilizeReportDTO.setSterilizeDTO(sterilizeDTO);
        sterilizeReportDTO.setTreatments(treatments);

        return sterilizeReportDTO;
    }
}
