package vote.back.animal.adapter.out.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class OutAnimalDetailsDTO {
    private Long animalId;
    private String name;
    private Integer count;
    private String imageName;
    private String description;
    private String details;

    @QueryProjection
    public OutAnimalDetailsDTO(Long animalId, String name, Integer count, String imageName, String description, String details) {
        this.animalId = animalId;
        this.name = name;
        this.count = count;
        this.imageName = imageName;
        this.description = description;
        this.details = details;
    }
}
