package vote.back.animal.adapter.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutAnimalCacheDto implements Serializable {
    private Long animalId;
    private String name;
    private String description;
    private String details;
    private String imageName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutAnimalCacheDto that = (OutAnimalCacheDto) o;
        return Objects.equals(animalId, that.animalId) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(details, that.details) && Objects.equals(imageName, that.imageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, name, description, details, imageName);
    }
}
