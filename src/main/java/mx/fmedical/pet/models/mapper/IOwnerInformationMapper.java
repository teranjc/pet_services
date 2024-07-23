package mx.fmedical.pet.models.mapper;

import mx.fmedical.pet.models.dto.OwnerInformationDTO;
import mx.fmedical.pet.models.entities.OwnerInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IOwnerInformationMapper {
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "age", source = "age")
    OwnerInformation addOwnerInformation(OwnerInformationDTO ownerInformationDTO);
}
