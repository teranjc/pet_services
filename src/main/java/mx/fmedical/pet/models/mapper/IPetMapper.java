package mx.fmedical.pet.models.mapper;

import mx.fmedical.pet.models.dto.PetDTO;
import mx.fmedical.pet.models.entities.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface IPetMapper {
    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "species", source = "species"),
            @Mapping(target = "breed", source = "breed"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "weight", source = "weight"),
            @Mapping(target = "sex", source = "sex"),
            @Mapping(target = "color", source = "color"),
            @Mapping(target = "currentVaccination", source = "currentVaccination")

    })
    Pet toPet(PetDTO petDTO);

    PetDTO toPetDTO(Pet pet);

}
