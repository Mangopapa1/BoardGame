package BoardGame.BackEnd.Repository;

import BoardGame.BackEnd.Entity.BoardGame;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardGameRepository {

    private final EntityManager em;


    //보드게임 조회
    public BoardGame findByName(String name){
        return em.find(BoardGame.class, name);
    }

    //장르별 조회
    public List<BoardGame> findByTypeStartingWith(String type) {
        return null;
    }

    //난이도별 조회
    public List<BoardGame> findByDifficultyStartingWith(String difficulty){
        return em.createQuery("select m from BoardGame m where m.difficulty like %:"+difficulty+"%", BoardGame.class).getResultList();
    }
}
