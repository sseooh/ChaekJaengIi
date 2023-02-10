package chaekjaengi.chaekjaengispring.controller;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    private final MemberService memberService;


    @Autowired
    public JoinController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("members/join")
    public String joinForm() {
        return "members/join";
    }

    @PostMapping("members/join")
    public String create(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setPwd(form.getPwd());

        memberService.join(member);

        return "home"; //??
    }
}
