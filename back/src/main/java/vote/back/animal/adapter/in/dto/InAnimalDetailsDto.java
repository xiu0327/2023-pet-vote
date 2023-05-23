package vote.back.animal.adapter.in.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InAnimalDetailsDto {
    private Long animalId;
    private String name;
    private String count;
    private String imageName;
    private String description;
    private String details;
    private Boolean isVoted;
}
