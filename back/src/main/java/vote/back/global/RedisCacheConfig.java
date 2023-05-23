package vote.back.global;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisCacheConfig {

    @Value("${spring.redis.cache.host}")
    private String host;

    @Value("${spring.redis.cache.port}")
    private int port;

    @Bean
    @Primary
    public RedisCacheManager animalCacheManager(){
        RedisCacheConfiguration configuration = getConfiguration();

        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
        cacheConfigurationMap
                .put(RedisCacheKey.ANIMAL_CACHE_KEY, RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofSeconds(60 * 5))); // 5 min

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory())
                .cacheDefaults(configuration)
                .withInitialCacheConfigurations(cacheConfigurationMap).build();
    }

    @Bean
    public RedisCacheManager animalVoteCountCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration configuration = getConfiguration();

        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
        cacheConfigurationMap
                .put(RedisCacheKey.ANIMAL_VOTE_COUNT_KEY, RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofSeconds(10))); // 10 sec

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory)
                .cacheDefaults(configuration)
                .withInitialCacheConfigurations(cacheConfigurationMap).build();
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory(host, port);
    }

    private RedisCacheConfiguration getConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofSeconds(60)) // 캐시의 기본 유효시간 설정 : 60초
                .computePrefixWith(CacheKeyPrefix.simple()) // Key Prefix 설정
                .serializeKeysWith(RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(new StringRedisSerializer()));
    }
}
