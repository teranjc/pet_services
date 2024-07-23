package mx.fmedical.pet.business.implementation;

import jakarta.transaction.Transactional;
import mx.fmedical.pet.business.IVetAssigmentBusiness;
import mx.fmedical.pet.models.dto.VetAssigmentByIdDTO;
import mx.fmedical.pet.models.dto.VetAssigmentDTO;
import mx.fmedical.pet.models.entities.VetAssigment;
import mx.fmedical.pet.models.mapper.IVetAssigmentMapper;
import mx.fmedical.pet.repository.IVetAssigmentRepository;
import mx.fmedical.pet.utils.exception.VetAssigmentSaveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetAssigmentBusiness implements IVetAssigmentBusiness {
    @Autowired
    private IVetAssigmentRepository iVetAssigmentRepository;

    @Autowired
    private IVetAssigmentMapper iVetAssigmentMapper;

    @Transactional
    @Override
    public VetAssigment saveVet(VetAssigmentDTO vetAssigmentDTO) {
        try {
            VetAssigment vetAssigment;
            vetAssigment = iVetAssigmentMapper.vetAssigmentAdd(vetAssigmentDTO);
            iVetAssigmentRepository.save(vetAssigment);
            VetAssigmentByIdDTO vetAssigmentByIdDTO = new VetAssigmentByIdDTO();
            vetAssigmentByIdDTO.setIdVetAssigment(vetAssigment.getIdVetAssigment());
            return vetAssigment;
        } catch (Exception e) {
            throw new VetAssigmentSaveException("No se pudo guardar el veterinario.", e);
        }
    }

    @Override
    public List<VetAssigment> findAllVetAssigned(String search) {
        return iVetAssigmentRepository.findAllVetAssigned(search);
    }
}

