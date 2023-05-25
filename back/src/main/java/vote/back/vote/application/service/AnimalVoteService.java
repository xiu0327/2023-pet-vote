package vote.back.vote.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vote.back.vote.application.port.in.VoteAnimalUseCase;
import vote.back.vote.application.port.in.VoteCancelAnimalUseCase;
import vote.back.vote.application.port.out.SendVoteRequestToProducerPort;

@Service
@RequiredArgsConstructor
@Transactional
public class AnimalVoteService implements VoteAnimalUseCase, VoteCancelAnimalUseCase {

    private final SendVoteRequestToProducerPort sendVoteRequestToProducerPort;

    @Override
    public void vote(Long animalId) {
        sendVoteRequestToProducerPort.send(animalId, 1);
    }

    @Override
    public void cancel(Long animalId) {
        sendVoteRequestToProducerPort.send(animalId, -1);
    }
}
