package BoardGame.BackEnd.Repository;

import BoardGame.BackEnd.Entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,String> {
    List<Review> findByBoardGameId(String boardGameId);


//    private final EntityManager em;
//
//    public void save(ReviewDto review){
//        em.persist(review);
//    }
//
//    public ReviewDto findOne(Long reviewId){
//        return em.find(ReviewDto.class, reviewId);
//    }
//
//    public List<ReviewDto> findAll(){
//        return em.createQuery("select m from Review m", ReviewDto.class).getResultList();
//    }`
}
