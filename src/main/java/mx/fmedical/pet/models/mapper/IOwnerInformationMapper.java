package mx.fmedical.pet.models.mapper;

import mx.fmedical.pet.models.dto.OwnerInformationDTO;
import mx.fmedical.pet.models.entities.OwnerInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface IOwnerInformationMapper {
    /*  @Mappings({
            @Mapping(target = "fullName", source = "fullName"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "phone", source = "phone"),
            @Mapping(target = "age", source = "age")
    })*/
    OwnerInformation addOwnerInformation(OwnerInformationDTO ownerInformationDTO);
}
