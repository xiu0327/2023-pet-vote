package vote.back.animal.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vote.back.animal.application.domain.AnimalType;

import java.util.Objects;

@Getter
public class AnimalRegisterDomainDto {
    private String name;
    private AnimalType type;
    private String description;
    private String details;
    private String imageName;

    @Builder
    public AnimalRegisterDomainDto(String name, AnimalType type, String description, String details, String imageName) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.details = details;
        this.imageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalRegisterDomainDto that = (AnimalRegisterDomainDto) o;
        return Objects.equals(name, that.name) && type == that.type && Objects.equals(description, that.description) && Objects.equals(details, that.details) && Objects.equals(imageName, that.imageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, description, details, imageName);
    }
}
