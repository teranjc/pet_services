package mx.fmedical.pet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SterilizeDTO {
    private String diffusion;
    private String size;
    private String institutionAssigment;
    private Integer reason;
    private String cause;
    private String idVetAssigment;
}
