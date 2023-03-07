package chaekjaengi.chaekjaengispring.service;

import chaekjaengi.chaekjaengispring.domain.Review;
import chaekjaengi.chaekjaengispring.repository.ReviewRepository;

public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review store (Review review){
        reviewRepository.save(review);
        return review;
    }
}
