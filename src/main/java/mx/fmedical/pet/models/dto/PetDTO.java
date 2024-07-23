package mx.fmedical.pet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetDTO {
    private String idPet;
    private String name;
    private String species;
    private String breed;
    private String age;
    private String weight;
    private String idOwnerInformation;
    private String sex;
    private String color;
    private String currentVaccination;
}
