package vote.back.animal.application.port.in;

import vote.back.animal.application.domain.Animal;
import vote.back.animal.application.dto.AnimalRegisterDomainDto;

public interface RegisterAnimalUseCase {
    void register(AnimalRegisterDomainDto dto);
}
