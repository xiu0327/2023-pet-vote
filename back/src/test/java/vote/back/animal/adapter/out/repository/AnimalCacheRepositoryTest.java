//package vote.back.animal.adapter.out.repository;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//@Transactional
//class AnimalCacheRepositoryTest {
//
//    @Autowired AnimalCacheRepository animalCacheRepository;
//
//    @Test
//    @DisplayName("animal 캐시 데이터를 저장하고 조회하는 통합 테스트")
//    void setAndGetAnimalCacheData(){
//        // 1. animal 데이터 생성
//        OutAnimalCacheDto animal = new OutAnimalCacheDto(
//                11L,
//                "오늘이",
//                "CAT",
//                "귀여운 오늘이는 디비 자는중",
//                "imageName");
//        // 2. cache 저장
//        Long key = 114L;
//        animalCacheRepository.setAnimalCache(key, animal);
//        // 3. cache 조회
//        OutAnimalCacheDto animalCache = animalCacheRepository.getAnimalCache(key);
//        assertThat(animalCache).isEqualTo(animal);
//    }
//
//    @Test
//    @DisplayName("animalVoteCount 캐시 데이터를 저장하고 조회하는 통합 테스트")
//    void setAndGetVoteCacheData(){
//        // 1. count 데이터 생성
//        OutAnimalVoteCountCacheDto count = new OutAnimalVoteCountCacheDto(
//                11L, 10);
//        // 2. cache 저장
//        Long key = 113L;
//        animalCacheRepository.setAnimalVoteCountCache(key, count);
//        // 3. cache 조회
//        OutAnimalVoteCountCacheDto countCache = animalCacheRepository.getAnimalVoteCountCache(key);
//        assertThat(countCache).isEqualTo(count);
//    }
//
//}