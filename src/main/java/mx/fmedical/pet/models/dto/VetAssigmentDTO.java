package mx.fmedical.pet.models.dto;

import lombok.Data;

@Data
public class VetAssigmentDTO {
    private String name;
    private String lastName;
    private String professionalLicense;

    public VetAssigmentDTO() {
    }

    public VetAssigmentDTO(String professionalLicense) {
        this.professionalLicense = professionalLicense;
    }
}

