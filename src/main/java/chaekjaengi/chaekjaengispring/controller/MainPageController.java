package chaekjaengi.chaekjaengispring.controller;

import chaekjaengi.chaekjaengispring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    private final MemberService memberService;

    @Autowired
    public MainPageController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/mainPage")
    public String MainPage(MemberForm form) {
        if(memberService.login(form.getId(), form.getPwd())) {
            System.out.println("비밀번호가 일치함");
            return "mainPage";
        } else {
            System.out.println("비밀번호 불일치");
            return "home";
        }
    }

}
