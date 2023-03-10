package chaekjaengi.chaekjaengispring.service;

import chaekjaengi.chaekjaengispring.domain.Review;
import chaekjaengi.chaekjaengispring.repository.ReviewRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review store (Review review){
        reviewRepository.save(review);
        return review;

    }

    public List<Review> getTitleInfo(String title){
        return reviewRepository.findByTitle(title);
    }
}
