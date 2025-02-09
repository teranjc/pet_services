package mx.fmedical.pet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginationPetDTO {
    private String name;
    private String fullName;
    private Timestamp registrationDate;
    private String idPetInformation;
}
