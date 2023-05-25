package vote.back.animal.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vote.back.animal.adapter.out.repository.AnimalCacheRepository;
import vote.back.animal.adapter.out.repository.AnimalUpdateQueryRepository;
import vote.back.animal.application.port.out.UpdateAnimalVoteCountPort;


@Repository
@RequiredArgsConstructor
public class AnimalVoteCountUpdateAdapter implements UpdateAnimalVoteCountPort {

    private final AnimalUpdateQueryRepository queryRepository;
    private final AnimalCacheRepository cacheRepository;

    @Override
    @Transactional
    public void update(Long animalId, int count) {
        queryRepository.update(animalId, count);
        cacheRepository.deleteCache(animalId);
    }
}
