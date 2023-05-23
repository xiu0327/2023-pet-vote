package vote.back.animal.application.port.in;

import vote.back.animal.application.dto.AnimalDetailsDomainDto;

public interface FindAnimalDetailUseCase {
    AnimalDetailsDomainDto findDetails(Long animalId, String ip);
}
