package mx.fmedical.pet.business;

import mx.fmedical.pet.models.dto.VetAssigmentDTO;
import mx.fmedical.pet.models.entities.VetAssigment;

import java.util.List;

public interface IVetAssigmentBusiness {
    VetAssigment saveVet(VetAssigmentDTO vetAssigmentDTO);

    List<VetAssigment> findAllVetAssigned(String search);
}
