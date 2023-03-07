package chaekjaengi.chaekjaengispring.repository;

import chaekjaengi.chaekjaengispring.domain.Review;

import javax.persistence.EntityManager;

public class JpaReviewRepository implements ReviewRepository{

    private final EntityManager em;

    public JpaReviewRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Review save(Review review) {
        em.persist(review);
        return review;
    }
}
