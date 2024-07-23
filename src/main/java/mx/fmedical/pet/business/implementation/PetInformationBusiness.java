package mx.fmedical.pet.business.implementation;

import mx.fmedical.pet.business.IPetInformationBusiness;
import mx.fmedical.pet.models.dto.*;
import mx.fmedical.pet.models.entities.OwnerInformation;
import mx.fmedical.pet.models.entities.Pet;
import mx.fmedical.pet.models.entities.PetInformation;
import mx.fmedical.pet.models.entities.VetAssigment;
import mx.fmedical.pet.models.mapper.IOwnerInformationMapper;
import mx.fmedical.pet.models.mapper.IPetMapper;
import mx.fmedical.pet.repository.IOwnerInformationRepository;
import mx.fmedical.pet.repository.IPetInformationRepository;
import mx.fmedical.pet.repository.IPetRepository;
import mx.fmedical.pet.repository.IVetAssigmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class PetInformationBusiness implements IPetInformationBusiness {
    @Autowired
    private IOwnerInformationMapper iOwnerInformationMapper;

    @Autowired
    private IPetMapper iPetMapper;

    @Autowired
    private IOwnerInformationRepository ownerInformationRepository;

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private IPetInformationRepository iPetInformationRepository;

    @Autowired
    private IVetAssigmentRepository iVetAssigmentRepository;

    @Override
    public PetInformationByIdDTO saveConsultation(PetConsultationDTO petConsultationDTO) {

        OwnerInformation ownerInformation;
        ownerInformation = iOwnerInformationMapper.addOwnerInformation(petConsultationDTO.getOwnerInformationDTO());
        ownerInformationRepository.save(ownerInformation);

        Pet pet;
        pet = iPetMapper.toPet(petConsultationDTO.getPetDTO());
        pet.setOwnerInformation(ownerInformation);
        petRepository.save(pet);

        VetAssigment vetAssigment = iVetAssigmentRepository.findById(petConsultationDTO.getIdVetAssigment())
                .orElseThrow(() -> new RuntimeException("Vet assignment not found for ID: " + petConsultationDTO.getIdVetAssigment()));

        //consulta
        PetInformation petInformation = new PetInformation();
        petInformation.setReasonConsultation(petConsultationDTO.getReasonConsultation());
        petInformation.setDirectInterrogation(petConsultationDTO.getDirectInterrogation());
        petInformation.setLevelAttention(petConsultationDTO.getLevelAttention());
        petInformation.setBehavior(petConsultationDTO.getBehavior());
        petInformation.setMarch(petConsultationDTO.getMarch());
        petInformation.setNutritionalCondition(petConsultationDTO.getNutritionalCondition());
        petInformation.setFr(petConsultationDTO.getFr());
        petInformation.setFc(petConsultationDTO.getFc());
        petInformation.setTemp(petConsultationDTO.getTemp());
        petInformation.setTrc(petConsultationDTO.getTrc());
        petInformation.setDiagnostic(petConsultationDTO.getDiagnostic());
        petInformation.setTreatment(petConsultationDTO.getTreatment());
        petInformation.setHydration(petConsultationDTO.getHydration());
        petInformation.setObservation(petConsultationDTO.getObservation());
        petInformation.setVetAssigment(vetAssigment);
        petInformation.setRegistrationDate(Timestamp.from(Instant.now()));
        petInformation.setType(1);
        petInformation.setPet(pet);

        iPetInformationRepository.save(petInformation);

        PetInformationByIdDTO petInformationByIdDTO = new PetInformationByIdDTO();
        petInformationByIdDTO.setIdPetInformation(petInformation.getIdPetInformation());
        return petInformationByIdDTO;
    }

    @Override
    public Page<PaginationPetDTO> paginationPet(Pageable pageable, String search) {
        return iPetInformationRepository.paginationPet(search, pageable);

    }

    @Override
    public PetInformationReportDTO petInformationReport(String idPetInformation) {
        return iPetInformationRepository.petInformationReport(idPetInformation);
    }
}
