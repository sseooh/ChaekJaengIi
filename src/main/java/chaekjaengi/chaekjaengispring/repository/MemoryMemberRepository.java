package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<String, String> store = new HashMap<>();

    @Override
    public Member save(Member member) {
        store.put(member.getId(), member.getPwd());
        return member;
    }

    @Override
    public Optional<String> findById(String id) {
        return store.keySet().stream()
                .filter(member -> member.equals(id))
                .findAny();
    }

    @Override
    public Optional<String> findByPwd(String pwd) {
        return store.values().stream()
                .filter(member -> member.equals(pwd))
                .findAny();
    }

}
