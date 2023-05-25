package vote.back.animal.adapter.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import vote.back.animal.adapter.infra.dto.AnimalVoteCountKafkaDTO;
import vote.back.animal.application.port.out.UpdateAnimalVoteCountPort;
import vote.back.global.KafkaTopicConfig;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnimalVoteCountConsumerAdapter {

    private final UpdateAnimalVoteCountPort updateAnimalVoteCountPort;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME, autoStartup = "true")
    public void consumer(String data){
        try {
            AnimalVoteCountKafkaDTO count = objectMapper.readValue(data, AnimalVoteCountKafkaDTO.class);
            updateAnimalVoteCountPort.update(
                    count.getAnimalId(),
                    count.getCount()
            );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
