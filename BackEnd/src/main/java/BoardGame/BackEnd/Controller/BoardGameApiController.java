package BoardGame.BackEnd.Controller;

import BoardGame.BackEnd.Entity.BoardGame;
import BoardGame.BackEnd.Repository.BoardGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardGameApiController {

    private final BoardGameRepository boardGameRepository;





    @GetMapping("/poyo/games") //모든게임조회
    public List<BoardGame> AllGames(){
        return boardGameRepository.findAll();
    }

    @GetMapping("/poyo/search/{name}") //이름
    public List<BoardGame> findByName(@PathVariable String name){
        return boardGameRepository.findByName(name);
    }

    @GetMapping("/poyo/search/{type}") //장르별
    public List<BoardGame> findByType(@PathVariable String type){
        return boardGameRepository.findByType(type);

    }

    @GetMapping("/poyo/search/{difficulty}") //난이도
    public List<BoardGame> findByDifficulty(@PathVariable String difficulty){
        return boardGameRepository.findByDifficulty(difficulty);
    }

    }


