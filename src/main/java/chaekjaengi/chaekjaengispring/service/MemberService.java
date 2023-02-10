package chaekjaengi.chaekjaengispring.service;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
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
}
