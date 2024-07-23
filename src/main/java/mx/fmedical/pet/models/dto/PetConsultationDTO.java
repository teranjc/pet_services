package mx.fmedical.pet.models.dto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class PetConsultationDTO {
    OwnerInformationDTO ownerInformationDTO;
    PetDTO petDTO;
    private String reasonConsultation;
    private String directInterrogation;
    private String levelAttention;
    private String behavior;
    private String march;
    private String nutritionalCondition;
    private String fr;
    private String fc;
    private String temp;
    private String trc;
    private String diagnostic;
    private String treatment;
    private String hydration;
    private String observation;
    private String idVetAssigment;
/*    ;
    private String idPet;*/
}
