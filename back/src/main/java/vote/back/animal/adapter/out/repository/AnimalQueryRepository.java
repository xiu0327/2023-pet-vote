package vote.back.animal.adapter.out.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import vote.back.animal.adapter.mapper.OutAnimalDtoMapper;
import vote.back.animal.adapter.out.dto.*;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;
import vote.back.global.RedisCacheKey;

import static vote.back.animal.application.domain.QAnimal.animal;
import static vote.back.animal.application.domain.QAnimalImage.animalImage;
import static vote.back.animal.application.domain.QAnimalVoteCount.animalVoteCount;

@Repository
@RequiredArgsConstructor
public class AnimalQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Cacheable(
            key = "#animalId",
            value = RedisCacheKey.ANIMAL_CACHE_KEY,
            cacheManager = "animalCacheManager"
    )
    public OutAnimalDTO getAnimal(Long animalId) {
        return jpaQueryFactory
                .select(new QOutAnimalDTO(
                        animal.animalId,
                        animal.name,
                        animal.description,
                        animal.details,
                        animalImage.imageName))
                .from(animal)
                .join(animalImage).on(animalImage.animalId.eq(animalId))
                .where(animal.animalId.eq(animalId))
                .fetchOne();
    }

    @Cacheable(
            key = "#animalId",
            value = RedisCacheKey.ANIMAL_VOTE_COUNT_KEY,
            cacheManager = "animalVoteCountCacheManager"
    )
    public OutAnimalVoteCountDTO getAnimalVoteCount(Long animalId) {
        return jpaQueryFactory
                .select(new QOutAnimalVoteCountDTO(
                        animal.animalId,
                        animalVoteCount.count))
                .from(animal)
                .join(animalVoteCount).on(animalVoteCount.animalId.eq(animalId))
                .where(animal.animalId.eq(animalId))
                .fetchOne();
    }
}
