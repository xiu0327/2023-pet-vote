package vote.back.animal.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vote.back.animal.adapter.in.dto.InAnimalDetailsDto;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;

@Mapper(componentModel = "spring")
public interface InAnimalDtoMapper {

    InAnimalDtoMapper INSTANCE = Mappers.getMapper(InAnimalDtoMapper.class);

    InAnimalDetailsDto detailsDomainDtoToInDetailsDto(AnimalDetailsDomainDto dto);
}
