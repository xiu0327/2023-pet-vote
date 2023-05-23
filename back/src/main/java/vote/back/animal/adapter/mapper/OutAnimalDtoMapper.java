package vote.back.animal.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import vote.back.animal.adapter.out.dto.OutAnimalDetailsDTO;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;

@Mapper(componentModel = "spring")
public interface OutAnimalDtoMapper {

    OutAnimalDtoMapper INSTANCE = Mappers.getMapper(OutAnimalDtoMapper.class);

    @Mapping(source = "isVoted", target = "isVoted", ignore = true)
    AnimalDetailsDomainDto toAnimalDetailsDtoFromOutDetailsDto(OutAnimalDetailsDTO dto, Boolean isVoted);
}
