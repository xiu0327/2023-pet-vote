package vote.back.animal.application.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import vote.back.animal.application.domain.AnimalType;
import vote.back.animal.application.dto.AnimalRegisterDomainDto;
import vote.back.animal.application.port.in.RegisterAnimalUseCase;

@SpringBootTest
@Transactional
class AnimalRegisterServiceTest {

    @Autowired RegisterAnimalUseCase registerAnimalUseCase;

    @Test
    @DisplayName("테스트를 위한 데이터 넣어두기")
    void register() {
        String[] catNames = {
                "나비",
                "삼색이",
                "야통이",
                "순자",
                "버내너",
                "오늘이"
        };
        String[] dogNames = {
                "멍멍이",
                "강형욱오른팔",
                "핫도그",
                "초코"
        };
        for (int i = 1 ; i <= 6; i++){
            AnimalRegisterDomainDto animal = new AnimalRegisterDomainDto(
                    catNames[i-1],
                    AnimalType.CAT,
                    "귀여운 고양이 ~",
                    "",
                    "CAT_" + i + ".jpge"
            );
            registerAnimalUseCase.register(animal);
        }

        for (int i = 1 ; i <= 4; i++){
            AnimalRegisterDomainDto animal = new AnimalRegisterDomainDto(
                    dogNames[i-1],
                    AnimalType.DOG,
                    "귀여운 개 ~",
                    "",
                    "DOG_" + i + ".jpge"
            );
            registerAnimalUseCase.register(animal);
        }


    }
}