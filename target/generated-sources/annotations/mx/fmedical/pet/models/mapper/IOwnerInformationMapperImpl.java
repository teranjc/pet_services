package mx.fmedical.pet.models.mapper;

import javax.annotation.processing.Generated;
import mx.fmedical.pet.models.dto.OwnerInformationDTO;
import mx.fmedical.pet.models.entities.OwnerInformation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class IOwnerInformationMapperImpl implements IOwnerInformationMapper {

    @Override
    public OwnerInformation addOwnerInformation(OwnerInformationDTO ownerInformationDTO) {
        if ( ownerInformationDTO == null ) {
            return null;
        }

        OwnerInformation ownerInformation = new OwnerInformation();

        ownerInformation.setFullName( ownerInformationDTO.getFullName() );
        ownerInformation.setAddress( ownerInformationDTO.getAddress() );
        ownerInformation.setPhone( ownerInformationDTO.getPhone() );
        ownerInformation.setAge( ownerInformationDTO.getAge() );

        return ownerInformation;
    }
}
