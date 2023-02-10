package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, String>, MemberRepository {
    @Override
    Optional<Member> findById(String id);
    @Override
    Optional<Member> findByPwd(String pwd);
}
