package vote.back.animal.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vote.back.animal.adapter.out.dto.OutAnimalDTO;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;

@Mapper(componentModel = "spring")
public interface OutAnimalDtoMapper {

    OutAnimalDtoMapper INSTANCE = Mappers.getMapper(OutAnimalDtoMapper.class);

    AnimalDetailsDomainDto toAnimalDetailsDtoFromOutDetailsDto(OutAnimalDTO dto, Integer count);
}
