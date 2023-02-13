package chaekjaengi.chaekjaengispring.service;

import org.springframework.transaction.annotation.Transactional;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.repository.MemberRepository;
import java.util.Optional;
import java.util.List;


//@Service

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 중복 검증
    private void validateDuplicateMember(Member member){
        Optional<Member> result = memberRepository.findById(member.getId());
        result.ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

    }

    public boolean login(String id, String pwd) {
        if(!memberRepository.findById(id).isEmpty() && memberRepository.findById(id).equals(memberRepository.findByPwd(pwd))) return true;
        else return false;
    }

    /*
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId) {
        return memberRepository.findById(memberId);
    }

     */
}
