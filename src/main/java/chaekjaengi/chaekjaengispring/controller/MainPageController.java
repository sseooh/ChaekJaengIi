package chaekjaengi.chaekjaengispring.controller;


import chaekjaengi.chaekjaengispring.domain.Board;
import chaekjaengi.chaekjaengispring.domain.Pagination;
import chaekjaengi.chaekjaengispring.repository.BoardRepository;
import chaekjaengi.chaekjaengispring.repository.ReviewRepository;
import chaekjaengi.chaekjaengispring.service.BoardService;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.service.MemberService;
import chaekjaengi.chaekjaengispring.web.SessionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String MainPage(MemberForm form, HttpServletRequest request, Model model, @RequestParam(defaultValue = "1") int page) {
        Member loginMember = memberService.login(form.getId(), form.getPwd());

        if(loginMember == null) {
            return "redirect:/";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);

//        model.addAttribute("list", boardService.boardList());
        /////////////
        int totalListCnt = boardService.findAllCnt();

        Pagination pagination = new Pagination(totalListCnt, page);

        int startIndex = pagination.getStartIndex();

        int pageSize = pagination.getPageSize();

        List<Board> boardList = boardService.findListPaging(startIndex, pageSize);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pagination", pagination);
        /////////////

        return "mainPage";
    }

    @GetMapping("/mainPage")
    public String Board(Model model, @RequestParam(defaultValue = "1") int page) {
        int totalListCnt = boardService.findAllCnt();

        Pagination pagination = new Pagination(totalListCnt, page);

        int startIndex = pagination.getStartIndex();

        int pageSize = pagination.getPageSize();

        List<Board> boardList = boardService.findListPaging(startIndex, pageSize);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pagination", pagination);

        return "mainPage";
    }

    @GetMapping("/test")
    public String Test(Model model, @RequestParam(defaultValue = "1") int page) {
        int totalListCnt = boardService.findAllCnt();

        Pagination pagination = new Pagination(totalListCnt, page);

        int startIndex = pagination.getStartIndex();

        int pageSize = pagination.getPageSize();

        List<Board> boardList = boardService.findListPaging(startIndex, pageSize);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pagination", pagination);
//        return "pagingTest/index";
        return "redirect:/";

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
