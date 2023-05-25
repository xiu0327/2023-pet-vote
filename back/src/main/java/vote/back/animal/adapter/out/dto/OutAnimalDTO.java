package vote.back.animal.adapter.out.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class OutAnimalDTO {
    private Long animalId;
    private String name;
    private String description;
    private String details;
    private String imageName;

    @QueryProjection
    public OutAnimalDTO(Long animalId, String name, String description, String details, String imageName) {
        this.animalId = animalId;
        this.name = name;
        this.description = description;
        this.details = details;
        this.imageName = imageName;
    }
}
