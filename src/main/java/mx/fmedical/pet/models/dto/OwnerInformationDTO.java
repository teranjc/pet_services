package mx.fmedical.pet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnerInformationDTO {
    private String fullName;
    private String address;
    private String phone;
    private String age;
}
