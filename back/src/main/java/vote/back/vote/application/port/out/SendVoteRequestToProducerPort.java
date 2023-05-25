package vote.back.vote.application.port.out;

public interface SendVoteRequestToProducerPort {
    void send(Long animalId, int count);
}
