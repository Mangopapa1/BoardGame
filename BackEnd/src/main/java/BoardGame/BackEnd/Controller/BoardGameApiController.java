package BoardGame.BackEnd.Controller;

import BoardGame.BackEnd.Dto.BoardGameDto;
import BoardGame.BackEnd.Entity.BoardGame;
import BoardGame.BackEnd.Service.Impl.BoardGameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poyo")
public class BoardGameApiController {

    private final BoardGameServiceImpl boardGameService;



    @GetMapping("/games") //모든게임조회
    public List<BoardGameDto> AllGames(){
        return boardGameService.getAllGames();
    }

    @GetMapping("/search/name/{name}") //이름
    public Optional<BoardGame> findByName(@PathVariable String name){
        return boardGameService.getNameGame(name);
    }

    @GetMapping("/search/type/{type}") //장르별
    public List<BoardGameDto> findByType(@PathVariable String type){
        return boardGameService.getTypeGames(type);

    }

    @GetMapping("/search/difficulty/{difficulty}") //난이도
    public List<BoardGameDto> findByDifficulty(@PathVariable String difficulty){
        return boardGameService.getDifficultyGames(difficulty);
    }

    }


