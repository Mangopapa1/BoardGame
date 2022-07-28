package BoardGame.BackEnd.Repository;

import BoardGame.BackEnd.Entity.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {

    Optional<BoardGame> findByNameLike(String name); //이름 검색

    List<BoardGame> findByDifficultyLike(String difficulty); //난이도 검색

    List<BoardGame> findByCategoryLike(String category); //장르별 검색
    
    List<BoardGame> findByPlayersLike(String players); //인원별 검색












}
