package BoardGame.BackEnd.Service;

import BoardGame.BackEnd.Entity.BoardGame;
import BoardGame.BackEnd.Repository.BoardGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardGameService {

    private final BoardGameRepository boardGameRepository;

    public List<BoardGame> findType(){
        return boardGameRepository.findType();
    }

    public List<BoardGame> findDifficulty(){
        return boardGameRepository.findDifficulty();
    }

    public BoardGame findOne(String name){
        return boardGameRepository.findOne(name);
    }




}
