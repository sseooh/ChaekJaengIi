package chaekjaengi.chaekjaengispring;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member= new Member();
        member.setId("leejieun");
        member.setPwd("12345");

        //when
        repository.save(member);

        //then
        Optional<Member> result = repository.findById(member.getId());
        Optional<Member> result2 = repository.findByPwd(member.getPwd());
        assertThat(member.getId()).isEqualTo(result);
        // member.getId와 result의 값이 같으면 정상 실행 (save 실행 했을 때)
        assertThat(member.getPwd()).isEqualTo(result2);
    }

    @Test
    public void findById(){
        Member member1 = new Member();
        member1.setId("leejieun");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("leejieun");
        repository.save(member2);

        String result = repository.findById("leejieun").get();
        assertThat(result).isEqualTo(member1.getId());


    }

}
