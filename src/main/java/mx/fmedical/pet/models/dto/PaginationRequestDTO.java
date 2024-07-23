package mx.fmedical.pet.models.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PaginationRequestDTO {
    private int page;
    private int size;
    private String search;
    private Timestamp startDates;
    private Timestamp endDates;
}
