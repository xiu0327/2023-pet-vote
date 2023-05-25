package vote.back.animal.application.port.out;

public interface UpdateAnimalVoteCountPort {
    void update(Long animalId, int count);
}
