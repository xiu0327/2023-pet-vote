package vote.back.animal.adapter.out.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static vote.back.animal.application.domain.QAnimalVoteCount.animalVoteCount;

@Repository
@RequiredArgsConstructor
public class AnimalUpdateQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager em;

    public void update(Long animalId, int count) {
        // TODO : 등록되지 animalId 가 요청될 경우 에러 처리
        long result = jpaQueryFactory.update(animalVoteCount)
                .set(animalVoteCount.count, animalVoteCount.count.add(count))
                .where(animalVoteCount.animalId.eq(animalId),
                        isZeroCount(count))
                .execute();
        em.flush();
        em.clear();
    }

    private BooleanExpression isZeroCount(int count){
        if (count < 0){
            return animalVoteCount.count.ne(0);
        }
        return null;
    }
}
