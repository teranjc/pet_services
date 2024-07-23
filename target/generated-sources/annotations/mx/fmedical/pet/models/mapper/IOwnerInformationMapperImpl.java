package mx.fmedical.pet.models.mapper;

import javax.annotation.processing.Generated;
import mx.fmedical.pet.models.dto.OwnerInformationDTO;
import mx.fmedical.pet.models.entities.OwnerInformation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T17:12:02-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
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
