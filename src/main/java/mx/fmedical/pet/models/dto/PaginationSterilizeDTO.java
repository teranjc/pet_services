package mx.fmedical.pet.models.dto;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class PaginationSterilizeDTO {
    private String name;
    private String fullName;
    private Timestamp registrationDate;
    private String idSterilize;

    public PaginationSterilizeDTO() {
    }

    public PaginationSterilizeDTO(String name, String fullName, Timestamp registrationDate, String idSterilize) {
        this.name = name;
        this.fullName = fullName;
        this.registrationDate = registrationDate;
        this.idSterilize = idSterilize;
    }
}
