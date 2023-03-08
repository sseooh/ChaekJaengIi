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

    private final MemoryMemberRepository memoryMemberRepository;

    @Autowired
    public ReviewController(ReviewService reviewService, ReviewRepository reviewRepository, MemoryMemberRepository memoryMemberRepository) {
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
        this.memoryMemberRepository = memoryMemberRepository;
    }


    @RequestMapping(value = "/saveReview", method = RequestMethod.POST, produces = "application/html; charset=UTF-8")
    public String storeCheck(ReviewForm reviewForm, @SessionAttribute(name = "loginMember") Member member)throws Exception{

        //HttpSession session = request.getSession();
        //Member constant_member = (Member) session.getAttribute("loginMember").;
        //String constant_id = constant_member.getId();

        Review review = new Review();
        //책 제목이랑 아이디 받아오기

        review.setTitle("이지은");
        //review.setId("leejieun");
        review.setId(member.getId());
        review.setName(reviewForm.getName());
        review.setContent(reviewForm.getContent());

        reviewService.store(review);

        return "/mainPage";
    }

    @PostMapping("review")
    public String getWritePage(String title, Model model) {
        model.addAttribute("title", title);
        return "/review";
    }

}
