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


    @GetMapping("/members/joinForm")
    public String joinForm() {
        return "members/join";
    }

    @PostMapping("/members/join")
    public String create(MemberForm form){
        Member member = new Member();
        System.out.println(form.getId());
        member.setId(form.getId());
        member.setPwd(form.getPwd());
        System.out.println("111111111111111");

        memberService.join(member, form.getPwd_check());

        System.out.println("222222222222222");

        return "redirect:/";
    }
}
