package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(String id);

    Optional<Member> findByPwd(String pwd);

    List<Member> findAll();


}
