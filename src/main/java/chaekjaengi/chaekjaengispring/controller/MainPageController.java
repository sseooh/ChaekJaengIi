package chaekjaengi.chaekjaengispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("mainPage")
    public String MainPage() {
        return "mainPage";
    }
}
