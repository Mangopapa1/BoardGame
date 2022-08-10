package BoardGame.BackEnd.Controller;

import BoardGame.BackEnd.Dto.BoardGameDto;
import BoardGame.BackEnd.Entity.BoardGame;
import BoardGame.BackEnd.Service.Impl.BoardGameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poyo")
@CrossOrigin(origins = "http://54.180.58.142:8080")
public class BoardGameApiController {

    private final BoardGameServiceImpl boardGameService;



    @GetMapping("/games") //모든게임조회
    public List<BoardGameDto> AllGames(){
        return boardGameService.getAllGames();
    }

    @GetMapping("/search/{name}") //이름
    public List<BoardGameDto> findByName(@PathVariable String name){
        return boardGameService.getNameGame(name);
    }

    @GetMapping("/search/{type}") //장르별
    public List<BoardGameDto> findByType(@PathVariable String type){
        return boardGameService.getTypeGames(type);

    }

    @GetMapping("/poyo/search/{difficulty}") //난이도
    public List<BoardGameDto> findByDifficulty(@PathVariable String difficulty){
        return boardGameService.getDifficultyGames(difficulty);
    }

    }


