package vote.back.animal.application.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "animal_vote_count")
public class AnimalVoteCount {

    @Id
    @Column(name = "animal_id", nullable = false)
    private Long animalId;

    @Column(name = "count")
    private Integer count;

    public AnimalVoteCount() {
    }

    private AnimalVoteCount(Long animalId) {
        this.animalId = animalId;
        this.count = 0;
    }

    public static AnimalVoteCount initCount(Long animalId){
        return new AnimalVoteCount(animalId);
    }
}
