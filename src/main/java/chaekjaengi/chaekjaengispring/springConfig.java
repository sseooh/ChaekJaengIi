package chaekjaengi.chaekjaengispring;

import chaekjaengi.chaekjaengispring.repository.JpaMemberRepository;
import chaekjaengi.chaekjaengispring.repository.JpaReviewRepository;
import chaekjaengi.chaekjaengispring.repository.MemberRepository;
import chaekjaengi.chaekjaengispring.repository.ReviewRepository;
import chaekjaengi.chaekjaengispring.service.MemberService;
import chaekjaengi.chaekjaengispring.service.ReviewService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class springConfig {
    private final DataSource dataSource;
    private final EntityManager em;

    public springConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public ReviewService reviewService() {
        return new ReviewService(reviewRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }

    @Bean
    public ReviewRepository reviewRepository() {
        return new JpaReviewRepository(em);
    }
}
