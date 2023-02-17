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
    public boolean idCheck;
    public boolean pwdCheck;

    //@Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean join(Member member, String pwd_check){
        idCheck = validateDuplicateMember(member);
        pwdCheck = validatePwd(member, pwd_check);
        if(idCheck && pwdCheck) {
            memberRepository.save(member);
        }

        return idCheck && pwdCheck;
    }

    private boolean validatePwd(Member member, String pwd_check) {
        if(member.getPwd().equals(pwd_check)) {
            System.out.println("33333333333");
            return true;
        }else
            System.out.println("4444444444444");
            return false;
    }


    // 중복 검증
    private boolean validateDuplicateMember(Member member){
        if(memberRepository.findById(member.getId()).isPresent()){
            System.out.println("111111111111111");
            return false;
        }
        else
            System.out.println("222222222222222");
            return true;
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
