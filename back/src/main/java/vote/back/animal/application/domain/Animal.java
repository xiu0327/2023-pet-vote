package vote.back.animal.application.domain;

import lombok.Builder;
import lombok.Getter;
import vote.back.animal.application.domain.AnimalType;

import javax.persistence.*;

@Getter
@Table(name = "animal")
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long animalId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AnimalType type;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "details", nullable = false)
    private String details;

    public Animal() {
    }

    private Animal(String name, AnimalType type, String description, String details) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.details = details;
    }

    public static Animal register(String name, AnimalType type, String description, String details){
        return new Animal(name, type, description, details);
    }

    public static Animal simpleRegister(String name, AnimalType type,  String description){
        return new Animal(name, type, description, "");
    }


}
