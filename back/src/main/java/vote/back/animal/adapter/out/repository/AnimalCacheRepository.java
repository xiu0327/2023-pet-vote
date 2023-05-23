package vote.back.animal.adapter.out.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Repository;
import vote.back.animal.adapter.out.dto.OutAnimalCacheDto;
import vote.back.animal.adapter.out.dto.OutAnimalVoteCountCacheDto;
import vote.back.global.RedisCacheKey;

import java.util.Optional;

@Repository
public class AnimalCacheRepository {

    private final RedisCacheManager animalCache;
    private final RedisCacheManager animalVoteCache;

    public AnimalCacheRepository(
            @Qualifier("animalCacheManager") RedisCacheManager animalCacheManager,
            @Qualifier("animalVoteCountCacheManager") RedisCacheManager animalVoteCacheManager) {
        this.animalCache = animalCacheManager;
        this.animalVoteCache = animalVoteCacheManager;
    }

    public OutAnimalCacheDto getAnimalCache(Long key){
        Cache cache = animalCache.getCache(RedisCacheKey.ANIMAL_CACHE_KEY);
        if (cache != null){
            return cache.get(key, OutAnimalCacheDto.class);
        }
        return null;
    }

    public OutAnimalVoteCountCacheDto getAnimalVoteCountCache(Long key){
        Cache cache = animalVoteCache.getCache(RedisCacheKey.ANIMAL_VOTE_COUNT_KEY);
        if (cache != null){
            return cache.get(key, OutAnimalVoteCountCacheDto.class);
        }
        return null;
    }

    public void setAnimalCache(Long key, OutAnimalCacheDto value){
        Cache cache = animalCache.getCache(RedisCacheKey.ANIMAL_CACHE_KEY);
        if (cache != null){
            cache.put(key, value);
        }
    }

    public void setAnimalVoteCountCache(Long key, OutAnimalVoteCountCacheDto value){
        Cache cache = animalVoteCache.getCache(RedisCacheKey.ANIMAL_VOTE_COUNT_KEY);
        if (cache != null){
            cache.put(key, value);
        }
    }
}
