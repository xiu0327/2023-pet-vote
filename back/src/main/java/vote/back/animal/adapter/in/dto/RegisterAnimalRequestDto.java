package vote.back.animal.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAnimalRequestDto {
    private String name;
    private String type;
    private String description;
    private String details;
    private String imageName;
}
