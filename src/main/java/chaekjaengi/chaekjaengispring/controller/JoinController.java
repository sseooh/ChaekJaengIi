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


   /* @PostMapping("/members/join")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setId(form.getId());
        member.setPwd(form.getPwd());

        if (memberService.join(member, form.getPwd_check()) == false) {

        }

        return "redirect:/";
    }

    */

    @RequestMapping(value = "/members/join", method = RequestMethod.POST, produces = "application/html; charset=UTF-8")
    public String joinCheck (Model model, MemberForm form)throws Exception  {
        Member member = new Member();
        member.setId(form.getId());
        member.setPwd(form.getPwd());

        String result = memberService.join(member, form.getPwd_check());

        switch (result) {
            case "success":
                model.addAttribute("msg", "회원가입이 완료되었습니다.");
                model.addAttribute("url", "/home");
                break;
            case "idCheck fail":
                model.addAttribute("msg", "중복된 id가 존재합니다.");
                model.addAttribute("url", "/");
                break;
            case "pwdCheck fail":
                model.addAttribute("msg", "비밀번호가 다릅니다.");
                model.addAttribute("url", "/");
                break;
            case "fail":
                model.addAttribute("msg", "중복된 id가 존재하며, 비밀번호가 다릅니다.");
                model.addAttribute("url", "/");
                break;
        }

        return "alert";

    }
}
