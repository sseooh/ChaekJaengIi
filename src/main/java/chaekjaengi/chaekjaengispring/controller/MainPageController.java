package chaekjaengi.chaekjaengispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    @PostMapping ("mainPage")
    public String MainPage() {return "mainPage";}
}
