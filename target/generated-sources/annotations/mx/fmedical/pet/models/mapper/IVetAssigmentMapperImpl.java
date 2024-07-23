package mx.fmedical.pet.models.mapper;

import javax.annotation.processing.Generated;
import mx.fmedical.pet.models.dto.VetAssigmentDTO;
import mx.fmedical.pet.models.entities.VetAssigment;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T17:12:02-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class IVetAssigmentMapperImpl implements IVetAssigmentMapper {

    @Override
    public VetAssigment vetAssigmentAdd(VetAssigmentDTO venetAssigmentDTO) {
        if ( venetAssigmentDTO == null ) {
            return null;
        }

        VetAssigment vetAssigment = new VetAssigment();

        vetAssigment.setName( venetAssigmentDTO.getName() );
        vetAssigment.setLastName( venetAssigmentDTO.getLastName() );
        vetAssigment.setProfessionalLicense( venetAssigmentDTO.getProfessionalLicense() );

        return vetAssigment;
    }
}
