package mx.fmedical.pet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreatmentDTO {
    private Integer percent;
    private String lotNumber;
    private String dateExpiry;
    private Double dosage;
    private String nameTreatment;
    private Boolean antibiotic;
    private Boolean other;

}
