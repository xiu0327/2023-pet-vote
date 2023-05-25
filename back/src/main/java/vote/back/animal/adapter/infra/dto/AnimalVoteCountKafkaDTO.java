package vote.back.animal.adapter.infra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalVoteCountKafkaDTO {
    private Long animalId;
    private int count;
}
