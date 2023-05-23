package vote.back.animal.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vote.back.animal.application.domain.Animal;
import vote.back.animal.application.domain.AnimalImage;
import vote.back.animal.application.domain.AnimalVoteCount;
import vote.back.animal.application.dto.AnimalRegisterDomainDto;
import vote.back.animal.application.port.in.RegisterAnimalUseCase;
import vote.back.animal.application.port.out.SaveAnimalPort;

@Service
@RequiredArgsConstructor
public class AnimalRegisterService implements RegisterAnimalUseCase {

    private final SaveAnimalPort persistenceAnimalPort;

    @Override
    public void register(AnimalRegisterDomainDto dto) {
        Long animalId = persistenceAnimalPort.saveAnimal(Animal.simpleRegister(
                dto.getName(),
                dto.getType(),
                dto.getDescription()
        ));
        persistenceAnimalPort.saveAnimalImage(AnimalImage.addMainImage(
                animalId,
                dto.getImageName()
        ));
        persistenceAnimalPort.saveAnimalVoteCount(AnimalVoteCount.initCount(animalId));
    }
}
