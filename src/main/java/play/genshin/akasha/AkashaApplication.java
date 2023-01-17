package play.genshin.akasha;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;

@ServletComponentScan
@SpringBootApplication
@EnableJpaAuditing
public class AkashaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkashaApplication.class, args);
	}

}
