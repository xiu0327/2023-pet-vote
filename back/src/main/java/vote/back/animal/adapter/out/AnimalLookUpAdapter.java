package vote.back.animal.adapter.out;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import vote.back.animal.adapter.mapper.OutAnimalCacheDtoMapper;
import vote.back.animal.adapter.out.dto.OutAnimalCacheDto;
import vote.back.animal.adapter.out.dto.OutAnimalVoteCountCacheDto;
import vote.back.animal.adapter.out.repository.AnimalCacheRepository;
import vote.back.animal.adapter.out.repository.AnimalQueryRepository;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;
import vote.back.animal.application.port.out.FindAnimalPort;


@Repository
@RequiredArgsConstructor
public class AnimalLookUpAdapter implements FindAnimalPort {

    private final AnimalQueryRepository queryRepository;
    private final AnimalCacheRepository cacheRepository;
    private final OutAnimalCacheDtoMapper cacheMapper;

    @Override
    public AnimalDetailsDomainDto find(Long animalId, String ip) {
        OutAnimalCacheDto animalCache = cacheRepository.getAnimalCache(animalId);
        OutAnimalVoteCountCacheDto animalVoteCountCache = cacheRepository.getAnimalVoteCountCache(animalId);
        // TODO : 해당 animalId에 투표를 했는지 안 했는지 Redis 에서 정보 가져오는 logic 짜기
        boolean isVoted = false;
        if (animalCache != null & animalVoteCountCache != null){
            return cacheMapper.cacheDtoToAnimalDetailsDomainDto(
                    animalCache,
                    animalVoteCountCache.getCount(),
                    isVoted);
        }
        AnimalDetailsDomainDto details = queryRepository.getDetails(animalId);
        cacheRepository.setAnimalCache(
                animalId,
                cacheMapper.detailsToAnimalCacheDto(details));
        cacheRepository.setAnimalVoteCountCache(
                animalId,
                cacheMapper.detailsToAnimalVoteCacheDto(details));
        return details;
    }

    private Long makeHashKey(Long animalId, String ip) {
        return ip.hashCode() * 31 * animalId;
    }

}
