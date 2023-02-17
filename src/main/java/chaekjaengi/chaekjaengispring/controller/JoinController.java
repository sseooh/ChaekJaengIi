package chaekjaengi.chaekjaengispring.controller;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.repository.MemberRepository;
import chaekjaengi.chaekjaengispring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLOutput;

@Controller
public class JoinController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;


    @Autowired
    public JoinController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }


    @GetMapping("/members/joinForm")
    public String joinForm() {
        return "members/join";
    }


    @RequestMapping(value = "/members/join", method = RequestMethod.POST, produces = "application/html; charset=UTF-8")
    public String joinCheck (Model model, MemberForm form)throws Exception  {
        Member member = new Member();
        member.setId(form.getId());
        member.setPwd(form.getPwd());


    }
}
