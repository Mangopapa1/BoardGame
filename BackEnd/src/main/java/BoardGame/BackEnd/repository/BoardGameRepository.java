package BoardGame.BackEnd.repository;

import BoardGame.BackEnd.entity.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {


    Optional<BoardGame> findByNameContaining(String name); //이름 검색


    List<BoardGame> findByTypeContaining(String type); //장르별 검색


    List<BoardGame> findByMinPlayer(int minPlayer); //인원별 검색

    List<BoardGame> findByMaxPlayer(int maxPlayer);


    List<BoardGame> findByDifficultyContaining(String difficulty); //난이도 검색
    
    Optional<BoardGame> findById(Long id); //id 검색












}
