package BoardGame.BackEnd.Repository;

import BoardGame.BackEnd.Entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,String> {
    List<Review> findByBoardGameId(Long boardGameId);
}
