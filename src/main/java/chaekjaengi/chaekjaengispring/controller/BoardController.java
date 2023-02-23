package chaekjaengi.chaekjaengispring.controller;

import chaekjaengi.chaekjaengispring.domain.Board;
import chaekjaengi.chaekjaengispring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class BoardController {
    /*

    @Autowired
    private BoardService boardService;

    @PostMapping("/board/writedo")
    public String boardWritePro(Board board) {
        boardService.write(board);
        return "";
    }

    /*
    @RequestMapping(value = "/mainBoard", method = RequestMethod.GET)
    public void list(Locale locale, Model model) {

    }

     */

    /*
    @GetMapping("/board/list")
    public String boardlist() {
        return "/";
    }

     */

}
