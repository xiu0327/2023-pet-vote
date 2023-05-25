package vote.back.animal.adapter.out;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import vote.back.animal.adapter.mapper.OutAnimalDtoMapper;
import vote.back.animal.adapter.out.dto.OutAnimalDTO;
import vote.back.animal.adapter.out.dto.OutAnimalVoteCountDTO;
import vote.back.animal.adapter.out.repository.AnimalQueryRepository;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;
import vote.back.animal.application.port.out.FindAnimalPort;


@Repository
@RequiredArgsConstructor
public class AnimalLookUpAdapter implements FindAnimalPort {

    private final AnimalQueryRepository queryRepository;
    private final OutAnimalDtoMapper mapper;

    @Override
    public AnimalDetailsDomainDto find(Long animalId) {
        OutAnimalDTO animal = queryRepository.getAnimal(animalId);
        OutAnimalVoteCountDTO animalVoteCount = queryRepository.getAnimalVoteCount(animalId);
        return mapper.toAnimalDetailsDtoFromOutDetailsDto(
                animal,
                animalVoteCount.getCount());
    }

}
