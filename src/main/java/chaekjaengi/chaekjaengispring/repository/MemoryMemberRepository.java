package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<String, Member> store = new HashMap<>();

    public String getReviewId() {
        return reviewId;
    }

    String reviewId;
    Optional ID;

    @Override
    public Member save(Member member) {
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        ID =(store.values().stream()
                .filter(member -> member.getId().equals(id))
                .findAny());
        reviewId = String.valueOf(ID);
        return ID;

    }

    @Override
    public Optional<Member> findByPwd(String pwd) {
        return store.values().stream()
                .filter(member -> member.getPwd().equals(pwd))
                .findAny();
    }



    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }



}
