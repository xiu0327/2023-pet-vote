package vote.back.animal.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import vote.back.animal.application.domain.Animal;
import vote.back.animal.application.domain.AnimalImage;
import vote.back.animal.application.domain.AnimalVoteCount;
import vote.back.animal.application.port.out.SaveAnimalPort;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AnimalSaveAdapter implements SaveAnimalPort {

    private final EntityManager em;

    @Override
    public Long saveAnimal(Animal animal) {
        em.persist(animal);
        return animal.getAnimalId();
    }

    @Override
    public void saveAnimalImage(AnimalImage image) {
        em.persist(image);
    }

    @Override
    public void saveAnimalVoteCount(AnimalVoteCount count) {
        em.persist(count);
    }
}
