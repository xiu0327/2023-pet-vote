package vote.back.animal.application.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "animal_image")
public class AnimalImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_image_id")
    private Long imageId;

    @Column(name = "animal_id", nullable = false)
    private Long animalId;

    @Column(name = "image_name", nullable = false)
    private String imageName;

    @Enumerated(EnumType.STRING)
    @Column(name = "image_type", nullable = false)
    private AnimalImageType imageType;

    public AnimalImage() {
    }

    private AnimalImage(Long animalId, String imageName, AnimalImageType imageType) {
        this.animalId = animalId;
        this.imageName = imageName;
        this.imageType = imageType;
    }

    public static AnimalImage addMainImage(Long animalId, String imageName){
        return new AnimalImage(animalId, imageName, AnimalImageType.MAIN);
    }

    public static AnimalImage addSubImage(Long animalId, String imageName){
        return new AnimalImage(animalId, imageName, AnimalImageType.SUB);
    }

}
