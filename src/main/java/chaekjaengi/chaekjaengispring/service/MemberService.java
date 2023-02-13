package chaekjaengi.chaekjaengispring.service;

import org.springframework.transaction.annotation.Transactional;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member, String pwd_check){
        validateDuplicateMember(member);
        //validatePwd(member, pwd_check);
        memberRepository.save(member);

        return member.getId();
    }

    private void validatePwd(Member member, String pwd_check) {
        if(member.getPwd() != pwd_check) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }

    // 중복 검증
    private void validateDuplicateMember(Member member){
        memberRepository.findById(member.getId())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

    }

    public boolean login(String id, String pwd) {
        if(!memberRepository.findById(id).isEmpty() && memberRepository.findById(id).equals(memberRepository.findByPwd(pwd))) return true;
        else return false;
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId) {
        return memberRepository.findById(memberId);
    }
}
