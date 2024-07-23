package mx.fmedical.pet.business;

import mx.fmedical.pet.models.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISterilizeBusiness {
    SteriliazeByIdDTO saveSterilize(SterilizeAddDTO sterilizeAddDTO);

    Page<PaginationSterilizeDTO> paginationSterilize(Pageable pageable, String search);

    SterilizeReportDTO sterilizeInformationReport(String idSteriliaze);
}
