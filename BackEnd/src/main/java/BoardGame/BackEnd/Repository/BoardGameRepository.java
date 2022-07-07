package BoardGame.BackEnd.Repository;

import BoardGame.BackEnd.Entity.BoardGame;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardGameRepository {

    private final EntityManager em;

    //보드게임 저장
    public void save(BoardGame boardGame){
        em.persist(boardGame);
    }

    //보드게임 검색
    public BoardGame findOne(String name){
        return em.find(BoardGame.class, name);

    }
    //장르별 검색
    public List<BoardGame> findType(){
        return em.createQuery("select m from BoardGame where type = ?").getResultList();
    }

    //난이도 별검색
    public List<BoardGame> findDifficulty(){
        return em.createQuery("select m from BoardGame where difficulty = ?").getResultList();
    }

}
