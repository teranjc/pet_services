package mx.fmedical.pet.models.mapper;

import javax.annotation.processing.Generated;
import mx.fmedical.pet.models.dto.PetDTO;
import mx.fmedical.pet.models.entities.Pet;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T17:12:02-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class IPetMapperImpl implements IPetMapper {

    @Override
    public Pet toPet(PetDTO petDTO) {
        if ( petDTO == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setIdPet( petDTO.getIdPet() );
        pet.setName( petDTO.getName() );
        pet.setSpecies( petDTO.getSpecies() );
        pet.setBreed( petDTO.getBreed() );
        pet.setAge( petDTO.getAge() );
        pet.setWeight( petDTO.getWeight() );
        pet.setSex( petDTO.getSex() );
        pet.setColor( petDTO.getColor() );
        pet.setCurrentVaccination( petDTO.getCurrentVaccination() );

        return pet;
    }

    @Override
    public PetDTO toPetDTO(Pet pet) {
        if ( pet == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setIdPet( pet.getIdPet() );
        petDTO.setName( pet.getName() );
        petDTO.setSpecies( pet.getSpecies() );
        petDTO.setBreed( pet.getBreed() );
        petDTO.setAge( pet.getAge() );
        petDTO.setWeight( pet.getWeight() );
        petDTO.setSex( pet.getSex() );
        petDTO.setColor( pet.getColor() );
        petDTO.setCurrentVaccination( pet.getCurrentVaccination() );

        return petDTO;
    }
}
