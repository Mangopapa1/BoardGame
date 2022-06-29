package BoardGame.BackEnd.Repository;

import BoardGame.BackEnd.DTO.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager em;

    public void save(ReviewDTO review){
        em.persist(review);
    }

    public ReviewDTO findOne(Long reviewId){
        return em.find(ReviewDTO.class, reviewId);
    }

    public List<ReviewDTO> findAll(){
        return em.createQuery("select m from Review m", ReviewDTO.class).getResultList();
    }
}
