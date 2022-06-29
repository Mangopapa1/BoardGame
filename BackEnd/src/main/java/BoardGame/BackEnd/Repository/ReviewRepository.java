package BoardGame.BackEnd.Repository;

import BoardGame.BackEnd.DTO.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;

    public void save(Review review){
        em.persist(review);
    }

    public Review findOne(Long reviewId){
        return em.find(Review.class, reviewId);
    }

    public List<Review> findAll(){
        return em.createQuery("select m from Review m", Review.class).getResultList();
    }
}
