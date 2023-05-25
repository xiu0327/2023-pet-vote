package vote.back.animal.adapter.out.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class OutAnimalVoteCountDTO {
    private Long animalId;
    private Integer count;

    @QueryProjection
    public OutAnimalVoteCountDTO(Long animalId, Integer count) {
        this.animalId = animalId;
        this.count = count;
    }
}
