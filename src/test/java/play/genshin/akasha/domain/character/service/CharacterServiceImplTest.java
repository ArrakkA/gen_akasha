package play.genshin.akasha.domain.character.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import play.genshin.akasha.domain.artifact.entity.Artifact;
import play.genshin.akasha.domain.character.entity.EffectiveOption;
import java.util.List;
import static play.genshin.akasha.domain.character.entity.QEffectiveOption.*;

import static play.genshin.akasha.domain.artifact.entity.QArtifact.*;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class CharacterServiceImplTest {

    JPAQueryFactory queryFactory;

    @Test
    public void re(){
        String userNameParam = "member1";
        Integer ageParam = 10;

        BooleanBuilder builder = new BooleanBuilder();

        //when

        Artifact artifact1 = queryFactory
                .select(artifact)
                .from(artifact).where(artifact.artifactNo.eq(1)).fetchOne();







    }
}