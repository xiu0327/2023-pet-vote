package vote.back.animal.adapter.out.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Repository;
import vote.back.global.RedisCacheKey;

@Repository
public class AnimalCacheRepository {

    private final RedisCacheManager animalVoteCache;

    public AnimalCacheRepository(
            @Qualifier("animalVoteCountCacheManager") RedisCacheManager animalVoteCacheManager) {
        this.animalVoteCache = animalVoteCacheManager;
    }

    public void deleteCache(Long key){
        Cache cache = animalVoteCache.getCache(RedisCacheKey.ANIMAL_VOTE_COUNT_KEY);
        if (cache != null){
            cache.evict(key);
        }
    }
}
