package mx.fmedical.pet.models.mapper;

import mx.fmedical.pet.models.dto.VetAssigmentDTO;
import mx.fmedical.pet.models.entities.VetAssigment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface IVetAssigmentMapper {

  /*   @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "professionalLicense", source = "professionalLicense")

    })*/
    VetAssigment vetAssigmentAdd(VetAssigmentDTO venetAssigmentDTO);
}
