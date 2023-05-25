package vote.back.global;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    public static final String TOPIC_NAME = "animal";

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
