package vote.back.animal.adapter.out.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import vote.back.animal.adapter.mapper.OutAnimalDtoMapper;
import vote.back.animal.adapter.out.dto.OutAnimalDetailsDTO;
import vote.back.animal.adapter.out.dto.QOutAnimalDetailsDTO;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;

import static vote.back.animal.application.domain.QAnimal.animal;
import static vote.back.animal.application.domain.QAnimalImage.animalImage;
import static vote.back.animal.application.domain.QAnimalVoteCount.animalVoteCount;

@Repository
@RequiredArgsConstructor
public class AnimalQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final OutAnimalDtoMapper mapper;

    public AnimalDetailsDomainDto getDetails(Long animalId) {
        OutAnimalDetailsDTO result = jpaQueryFactory
                .select(new QOutAnimalDetailsDTO(
                        animal.animalId,
                        animal.name,
                        animalVoteCount.count,
                        animalImage.imageName,
                        animal.description,
                        animal.details))
                .from(animal)
                .join(animalImage).on(animalImage.animalId.eq(animalId))
                .join(animalVoteCount).on(animalVoteCount.animalId.eq(animalId))
                .where(animal.animalId.eq(animalId))
                .fetchOne();
        return mapper.toAnimalDetailsDtoFromOutDetailsDto(result, null);
    }
}
