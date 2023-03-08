package chaekjaengi.chaekjaengispring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AjaxController {
    /*
    //@ResponseBody
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    //@RequestMapping(value = "/bookReview.write")
    public String dataSend(@RequestParam("title") String title) {
        //model.addAttribute("msg", title);
        //System.out.println(title);
        //String title = (String) param.get("title");
        System.out.println(title);
        return "review";
    }

     */
    /*
    @PostMapping("gotowrite")
    public String getWritePage(String title, Model model) {
        System.out.println(title);
        return "review";
    }

     */

    /*
    @PostMapping("bookReview/write")
    public String getWritePage(String title, Model model) {
        model.addAttribute("title", title);
        return "review";
    }

     */
}
