package mx.fmedical.pet.controller;


import jakarta.transaction.Transactional;
import mx.fmedical.pet.business.ISterilizeBusiness;
import mx.fmedical.pet.contollerUtil.contants.ControllerUtil;
import mx.fmedical.pet.models.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Hugo Gerardo Gonzalez Mendoza
 * @Date 18/07/2024 18:00
 * @Company Erillam Helthcare s. de r.l. de c.v.
 * @Project STERILIZE
 */

@RestController
@RequestMapping(ControllerUtil.CONTROLLER_STERILIZE)
public class SterilizeController {
    @Autowired
    private ISterilizeBusiness iSterilizeBusiness;

    @Transactional
    @PostMapping(ControllerUtil.ADD_STERILIZE)
    public ResponseEntity<?> saveSterilize(@RequestBody SterilizeAddDTO sterilizeAddDTO) {
        SteriliazeByIdDTO steriliazeByIdDTO = iSterilizeBusiness.saveSterilize(sterilizeAddDTO);
        return new ResponseEntity<>(steriliazeByIdDTO, HttpStatus.CREATED);
    }

    @PostMapping(ControllerUtil.PAGINATION_STERILIZE_INFORMATION)
    public ResponseEntity<Page<PaginationSterilizeDTO>> paginationSterilize(@RequestBody PaginationRequestDTO paginationRequestDTO) {
        int page = paginationRequestDTO.getPage();
        int size = paginationRequestDTO.getSize();
        String search = paginationRequestDTO.getSearch();

        Pageable pageable = PageRequest.of(page, size);

        Page<PaginationSterilizeDTO> paginationSterilizeDTOS =
                iSterilizeBusiness.paginationSterilize(pageable, search);

        return ResponseEntity.ok(paginationSterilizeDTOS);
    }

    @PostMapping(ControllerUtil.REPORT_STERILIZE_INFORMATION)
    public ResponseEntity<SterilizeReportDTO> sterilizeInformationReport(@RequestBody SteriliazeByIdDTO steriliazeByIdDTO) {
        SterilizeReportDTO sterilizeReportDTO = iSterilizeBusiness.sterilizeInformationReport(steriliazeByIdDTO.getIdSteriliaze());
        return ResponseEntity.ok(sterilizeReportDTO);
    }
}
