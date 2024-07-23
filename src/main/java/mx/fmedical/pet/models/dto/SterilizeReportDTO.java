package mx.fmedical.pet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SterilizeReportDTO {
    OwnerInformationDTO ownerInformationDTO;
    PetDTO petDTO;
    SterilizeDTO sterilizeDTO;
    VetAssigmentDTO doctorAssigment;
    private List<TreatmentDTO> treatments;

}
