package vote.back.animal.adapter.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutAnimalVoteCountCacheDto implements Serializable {
    private Long animalId;
    @Getter
    private Integer count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutAnimalVoteCountCacheDto that = (OutAnimalVoteCountCacheDto) o;
        return Objects.equals(animalId, that.animalId) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, count);
    }
}
