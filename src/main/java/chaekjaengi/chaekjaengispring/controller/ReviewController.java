package chaekjaengi.chaekjaengispring.controller;

import chaekjaengi.chaekjaengispring.domain.Member;
import chaekjaengi.chaekjaengispring.domain.Review;
import chaekjaengi.chaekjaengispring.repository.MemoryMemberRepository;
import chaekjaengi.chaekjaengispring.repository.ReviewRepository;
import chaekjaengi.chaekjaengispring.service.ReviewService;
import chaekjaengi.chaekjaengispring.web.SessionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;


    @Autowired
    public ReviewController(ReviewService reviewService, ReviewRepository reviewRepository) {
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
    }

    @RequestMapping(value = "/saveReview", method = RequestMethod.POST, produces = "application/html; charset=UTF-8")
    public String storeCheck(ReviewForm reviewForm, @SessionAttribute(name = "loginMember") Member member)throws Exception{


        //HttpSession session = request.getSession();
        //Member constant_member = (Member) session.getAttribute("loginMember").;
        //String constant_id = constant_member.getId();

        Review review = new Review();
        //책 제목이랑 아이디 받아오기

        review.setTitle(reviewForm.getTitle());
        review.setId(member.getId());
        review.setName(reviewForm.getName());
        review.setContent(reviewForm.getContent());

        reviewService.store(review);

        return "/mainPage";
    }


    @PostMapping("review")
    public String getWritePage(String title, Model model) {
        System.out.println(title);
        model.addAttribute("title", title);
        return "/review";
    }



    /*
    @ResponseBody
    @RequestMapping(value = "bookReview.write", method = RequestMethod.POST)
    public void toReview(String title, HttpServletRequest request) {
        //System.out.println(request.getParameter("title"));
        //System.out.println(title);
        //return "reviewList";
    }

     */

    /*
    @RequestMapping(value = "/review", method = {RequestMethod.POST})
    public String test(@ModelAttribute("title") @RequestParam("title") String bookTitle) {
        System.out.println(bookTitle);
        return "redirect:/";
    }

     */

}
