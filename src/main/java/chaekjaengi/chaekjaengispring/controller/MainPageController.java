package chaekjaengi.chaekjaengispring.controller;


import chaekjaengi.chaekjaengispring.domain.Board;
import chaekjaengi.chaekjaengispring.service.BoardService;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.service.MemberService;
import chaekjaengi.chaekjaengispring.web.SessionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainPageController {

    @Autowired
    private final BoardService boardService;

    private final MemberService memberService;

    @Autowired
    public MainPageController(MemberService memberService, BoardService boardService) {
        this.memberService = memberService;
        this.boardService = boardService;
    }

    @PostMapping("/mainPage")
    public String MainPage(MemberForm form, HttpServletRequest request, Model model) {
        Member loginMember = memberService.login(form.getId(), form.getPwd());

        if(loginMember == null) {
            return "redirect:/";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);

        model.addAttribute("list", boardService.boardList());

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
