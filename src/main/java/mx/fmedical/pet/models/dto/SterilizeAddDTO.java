package mx.fmedical.pet.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class SterilizeAddDTO {
    OwnerInformationDTO ownerInformationDTO;
    PetDTO petDTO;
    private String diffusion;
    private String weight;
    private String size;
    private String institutionAssigment;
    private Integer reason;
    private String cause;
    private String idVetAssigment;
    List<TreatmentDTO> treatmentDTO;


}
