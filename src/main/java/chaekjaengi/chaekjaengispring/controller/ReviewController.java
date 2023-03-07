package chaekjaengi.chaekjaengispring.controller;

import chaekjaengi.chaekjaengispring.domain.Review;
import chaekjaengi.chaekjaengispring.repository.ReviewRepository;
import chaekjaengi.chaekjaengispring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewService reviewService, ReviewRepository reviewRepository) {
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
    }

    @RequestMapping(value = "/mainPage", method = RequestMethod.POST, produces = "application/html; charset=UTF-8")
    public void storeCheck(ReviewForm reviewForm)throws Exception{

            Review review = new Review();
            //책 제목이랑 아이디 받아오기
            //review.setTitle();
            //review.setId();
            review.setName(reviewForm.getName());
            review.setContent(reviewForm.getContent());

            reviewService.store(review);
    }
}
