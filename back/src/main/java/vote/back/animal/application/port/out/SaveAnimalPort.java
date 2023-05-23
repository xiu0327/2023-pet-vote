package vote.back.animal.application.port.out;

import vote.back.animal.application.domain.Animal;
import vote.back.animal.application.domain.AnimalImage;
import vote.back.animal.application.domain.AnimalVoteCount;

public interface SaveAnimalPort {
    Long saveAnimal(Animal animal);
    void saveAnimalImage(AnimalImage image);
    void saveAnimalVoteCount(AnimalVoteCount count);
}
