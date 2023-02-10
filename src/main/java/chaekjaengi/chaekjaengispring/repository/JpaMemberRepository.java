package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public Member save(Member member) {
        em.persist(member); //영구 저장?
        return member;
    }

    @Override
    public Optional<Member> findById(String id) {
        List<Member> result = em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByPwd(String pwd) {
        List<Member> result = em.createQuery("select m from Member m where m.pwd = :pwd", Member.class)
                .setParameter("pwd", pwd)
                .getResultList();
        return result.stream().findAny();

    }
}
