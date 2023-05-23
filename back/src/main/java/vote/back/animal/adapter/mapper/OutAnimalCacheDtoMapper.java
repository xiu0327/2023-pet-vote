package vote.back.animal.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vote.back.animal.adapter.out.dto.OutAnimalCacheDto;
import vote.back.animal.adapter.out.dto.OutAnimalVoteCountCacheDto;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;

@Mapper(componentModel = "spring")
public interface OutAnimalCacheDtoMapper {

    OutAnimalCacheDtoMapper INSTANCE = Mappers.getMapper(OutAnimalCacheDtoMapper.class);

    AnimalDetailsDomainDto cacheDtoToAnimalDetailsDomainDto(OutAnimalCacheDto dto, Integer count, Boolean isVoted);

    OutAnimalCacheDto detailsToAnimalCacheDto(AnimalDetailsDomainDto dto);
    OutAnimalVoteCountCacheDto detailsToAnimalVoteCacheDto(AnimalDetailsDomainDto dto);
}
