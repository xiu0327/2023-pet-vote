package vote.back.animal.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vote.back.animal.adapter.in.dto.InAnimalDetailsDto;
import vote.back.animal.adapter.mapper.InAnimalDtoMapper;
import vote.back.animal.adapter.out.repository.AnimalQueryRepository;
import vote.back.animal.application.port.in.FindAnimalDetailUseCase;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class AnimalLookUpController {

    private final FindAnimalDetailUseCase findAnimalDetailUseCase;
    private final AnimalQueryRepository animalQueryRepository;
    private final InAnimalDtoMapper mapper;

    @GetMapping("/api/animal/{animalId}/details")
    public InAnimalDetailsDto findAnimalDetails(@PathVariable("animalId") Long animalId){
        String testIP = "testIP";
        return mapper.detailsDomainDtoToInDetailsDto(findAnimalDetailUseCase.findDetails(animalId, testIP));
    }

    @GetMapping("/api/test/{animalId}/details")
    public InAnimalDetailsDto testDetails(@PathVariable("animalId") Long animalId){
        return mapper.detailsDomainDtoToInDetailsDto(animalQueryRepository.getDetails(animalId));
    }
}
