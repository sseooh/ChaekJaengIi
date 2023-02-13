package chaekjaengi.chaekjaengispring;

import chaekjaengi.chaekjaengispring.repository.JpaMemberRepository;
import chaekjaengi.chaekjaengispring.repository.MemberRepository;
import chaekjaengi.chaekjaengispring.service.MemberService;
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
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}