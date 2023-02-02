package play.genshin.akasha.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EffectiveRepositoryNomalJPA {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public EffectiveRepositoryNomalJPA(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

}
