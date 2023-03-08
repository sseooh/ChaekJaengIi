package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Review;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository {
    Review save (Review review);
}
