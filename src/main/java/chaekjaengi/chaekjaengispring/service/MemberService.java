package chaekjaengi.chaekjaengispring.service;

import org.springframework.transaction.annotation.Transactional;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.repository.MemberRepository;

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

    public Member login(String id, String pwd) {

        // 아이디와 비밀번호 일치하는 경우 해당 Member 리턴
        // 일치하지 않는 경우 null 리턴
        return memberRepository.findById(id)
                .filter(m -> m.getPwd().equals(pwd))
                .orElse(null);
        /*
        if(!memberRepository.findById(id).isEmpty() && memberRepository.findById(id).get().getPwd().equals(pwd)) {
            //HttpSession session = request.getSession();
            //session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);
            return true;
        }
        else return false;
         */
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
