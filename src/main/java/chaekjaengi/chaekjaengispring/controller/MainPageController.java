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
            return "home";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);

        return "mainPage";

        /**
         * 로그아웃 기능 구현 필요
         */

        /*
        if(memberService.login(form.getId(), form.getPwd())) {
            System.out.println("비밀번호가 일치함");
            return "mainPage";
        } else {
            System.out.println("비밀번호 불일치");
            return "home";
        }
         */
    }

}
