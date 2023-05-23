package vote.back.animal.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class AnimalDetailsDomainDto {
    private Long animalId;
    private String name;
    private String count;
    private String imageName;
    private String description;
    private String details;
    private Boolean isVoted;
}
