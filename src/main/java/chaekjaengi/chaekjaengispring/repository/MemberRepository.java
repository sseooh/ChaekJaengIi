package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<String> findById(String id);

    Optional<String> findByPwd(String pwd);

}
