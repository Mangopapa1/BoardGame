package BoardGame.BackEnd.Repository;

import BoardGame.BackEnd.Entity.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {


    Optional<BoardGame> findByNameStartingWith(String name); //이름 검색



    @Query("select m from BoardGame m where m.type like %:type%")
    List<BoardGame> findByType(@Param("type") String type); //장르별 검색

    @Query("select m from BoardGame m where m.players like %:players%")
    List<BoardGame> findByPlayers(@Param("players") String players); //인원별 검색

    @Query("select m from BoardGame m where m.difficulty like %:difficulty%")
    List<BoardGame> findByDifficulty(@Param("difficulty") String difficulty); //난이도 검색












}
