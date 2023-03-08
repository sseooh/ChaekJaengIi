package chaekjaengi.chaekjaengispring.service;

import chaekjaengi.chaekjaengispring.domain.Review;
import chaekjaengi.chaekjaengispring.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ReviewService {
    @Autowired
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review store (Review review){
        reviewRepository.save(review);
        return review;
    }
}
