package BoardGame.BackEnd.Controller;

import BoardGame.BackEnd.Entity.BoardGame;
import BoardGame.BackEnd.Repository.BoardGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poyo")
public class BoardGameApiController {

    private final BoardGameRepository boardGameRepository;



    @GetMapping("/test")
    public String test(){

        return "test";
    }

    @GetMapping("/games") //모든게임조회
    public List<BoardGame> AllGames(){
        return boardGameRepository.findAll();
    }

    @GetMapping("/search/{name}") //이름
    public Optional<BoardGame> findName(@PathVariable String name){
        return boardGameRepository.findByNameLike(name);
    }

    @GetMapping("/search/{category}") //장르별
    public List<BoardGame> findCategory(@PathVariable String category){
        return boardGameRepository.findByCategoryLike(category);

    }

    @GetMapping("/search/{difficulty}") //난이도
    public List<BoardGame> findDifficulty(@PathVariable String difficulty){
        return boardGameRepository.findByDifficultyLike(difficulty);
    }

    }


