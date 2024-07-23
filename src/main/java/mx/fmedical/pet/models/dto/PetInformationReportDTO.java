package mx.fmedical.pet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetInformationReportDTO {
    private String fullName;
    private String address;
    private String phone;

    private String name;
    private String species;
    private String breed;
    private String age;
    private String weight;


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
    private Timestamp registrationDatePetInformation;

    private String nameVetAssigment;
    private String lastName;
    private String professionalLicense;

}
