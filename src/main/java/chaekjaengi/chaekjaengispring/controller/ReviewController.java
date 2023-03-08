package chaekjaengi.chaekjaengispring.controller;

import chaekjaengi.chaekjaengispring.domain.Review;
import chaekjaengi.chaekjaengispring.repository.MemoryMemberRepository;
import chaekjaengi.chaekjaengispring.repository.ReviewRepository;
import chaekjaengi.chaekjaengispring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String storeCheck(ReviewForm reviewForm)throws Exception{

        System.out.println("Test!");
            Review review = new Review();

            review.setTitle("원씽");
            review.setId(memoryMemberRepository.getReviewId());
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
