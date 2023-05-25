package vote.back.animal.application.port.out;

import vote.back.animal.application.dto.AnimalDetailsDomainDto;

public interface FindAnimalPort {
    AnimalDetailsDomainDto find(Long animalId);
}
