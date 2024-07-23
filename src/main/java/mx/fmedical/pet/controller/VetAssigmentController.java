package mx.fmedical.pet.controller;

import jakarta.transaction.Transactional;
import mx.fmedical.pet.business.IVetAssigmentBusiness;
import mx.fmedical.pet.contollerUtil.contants.ControllerUtil;
import mx.fmedical.pet.models.dto.VetAssigmentDTO;
import mx.fmedical.pet.models.dto.VetAssigmentSearchDTO;
import mx.fmedical.pet.models.entities.VetAssigment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Hugo Gerardo Gonzalez Mendoza
 * @Date 17/07/2024 18:00
 * @Company Erillam Helthcare s. de r.l. de c.v.
 * @Project PET
 */

@RestController
@RequestMapping(ControllerUtil.CONTROLLER_VET)
public class VetAssigmentController {
    @Autowired
    private IVetAssigmentBusiness iVetAssigmentBusiness;

    @Transactional
    @PostMapping(ControllerUtil.ADD_VET)
    public ResponseEntity<?> saveVet(@RequestBody VetAssigmentDTO vetAssigmentDTO) {
        System.out.println("OK");
        VetAssigment vetAssigment = iVetAssigmentBusiness.saveVet(vetAssigmentDTO);
        return new ResponseEntity<>(vetAssigment, HttpStatus.CREATED);
    }

     @PostMapping(ControllerUtil.VET_ASSIGNED_FIND_ALL)
    public ResponseEntity<?> findAllVetAssigned(@RequestBody VetAssigmentSearchDTO vetAssigmentSearchDTO) {
        return ResponseEntity.ok(iVetAssigmentBusiness.findAllVetAssigned(vetAssigmentSearchDTO.getSearch()));
    }



}
