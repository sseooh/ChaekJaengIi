package chaekjaengi.chaekjaengispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JoinController {

    @GetMapping("members/join")
    public String joinForm() {
        return "members/join";
    }
}
