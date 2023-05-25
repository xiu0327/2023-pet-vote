package vote.back.vote.adapter.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import vote.back.animal.adapter.infra.dto.AnimalVoteCountKafkaDTO;
import vote.back.global.KafkaTopicConfig;
import vote.back.vote.application.port.out.SendVoteRequestToProducerPort;

@Component
@RequiredArgsConstructor
public class AnimalVoteCountProducerAdapter implements SendVoteRequestToProducerPort {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public void send(Long animalId, int count) {
        try {
            AnimalVoteCountKafkaDTO data = new AnimalVoteCountKafkaDTO(animalId, count);
            String jsonData = objectMapper.writeValueAsString(data);
            kafkaTemplate.send(
                    KafkaTopicConfig.TOPIC_NAME,
                    jsonData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
