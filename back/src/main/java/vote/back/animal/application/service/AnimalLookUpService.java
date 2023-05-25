package vote.back.animal.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;
import vote.back.animal.application.port.in.FindAnimalDetailUseCase;
import vote.back.animal.application.port.out.FindAnimalPort;

@Service
@RequiredArgsConstructor
public class AnimalLookUpService implements FindAnimalDetailUseCase {

    private final FindAnimalPort findAnimalPort;

    @Override
    public AnimalDetailsDomainDto findDetails(Long animalId) {
        return findAnimalPort.find(animalId);
    }
}
