package chaekjaengi.chaekjaengispring.controller;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.service.MemberService;
import chaekjaengi.chaekjaengispring.web.SessionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainPageController {

    private final MemberService memberService;

    @Autowired
    public MainPageController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/mainPage")
    public String MainPage(MemberForm form, HttpServletRequest request) {
        Member loginMember = memberService.login(form.getId(), form.getPwd());

        if(loginMember == null) {
            return "redirect:/";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);

        return "mainPage";
    }

    @PostMapping("/logout")
    public String Logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

}
