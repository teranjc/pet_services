package mx.fmedical.pet.models.mapper;

import javax.annotation.processing.Generated;
import mx.fmedical.pet.models.dto.VetAssigmentDTO;
import mx.fmedical.pet.models.entities.VetAssigment;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
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
