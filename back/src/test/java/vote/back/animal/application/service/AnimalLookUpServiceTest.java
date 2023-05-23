package vote.back.animal.application.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import vote.back.animal.application.dto.AnimalDetailsDomainDto;
import vote.back.animal.application.port.in.FindAnimalDetailUseCase;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class AnimalLookUpServiceTest {

    @Autowired FindAnimalDetailUseCase findAnimalDetailUseCase;

    @Test
    @DisplayName("동물 상세 조회")
    void findDetails() {
        Long animalId = 11L;
        String ip = "127.0.1";
        AnimalDetailsDomainDto animal = findAnimalDetailUseCase.findDetails(animalId, ip);
        assertEquals("나비", animal.getName());
        assertNotNull(animal);
        log.info("animal = {}", animal);
    }
}