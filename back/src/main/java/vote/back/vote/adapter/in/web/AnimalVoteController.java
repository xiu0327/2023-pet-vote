package vote.back.vote.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vote.back.vote.application.port.in.VoteAnimalUseCase;
import vote.back.vote.application.port.in.VoteCancelAnimalUseCase;

@RestController
@RequiredArgsConstructor
public class AnimalVoteController {

    private final VoteAnimalUseCase voteAnimalUseCase;
    private final VoteCancelAnimalUseCase voteCancelAnimalUseCase;

    @GetMapping("/api/vote/{animalId}")
    public void vote(@PathVariable("animalId") Long animalId){
        // TODO : 투표를 한 Cookie 가 있다면 vote 를 실행하지 않고 Bad Request 에러 발생
        voteAnimalUseCase.vote(animalId);
    }

    @GetMapping("/api/vote/cancel/{animalId}")
    public void cancel(@PathVariable("animalId") Long animalId){
        // TODO : 투표를 한 Cookie 가 있다면 cancel 을 실행하고 Cookie 삭제
        voteCancelAnimalUseCase.cancel(animalId);
    }
}
