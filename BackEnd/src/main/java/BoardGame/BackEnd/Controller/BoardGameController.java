package BoardGame.BackEnd.Controller;

import BoardGame.BackEnd.Entity.BoardGame;
import BoardGame.BackEnd.Service.BoardGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poyo")
public class BoardGameController {

    public final BoardGameService boardGameService;

    @GetMapping("/search/{name}")
    public BoardGame searchName(@PathVariable String name){
        return boardGameService.findOne(name);
    }

    @GetMapping("/search/{type}")
    public List<BoardGame> searchType(@PathVariable String type){
        return boardGameService.findType(type);
    }

    @GetMapping("/search/{difficulty}")
        public List<BoardGame> searchDifficulty(@PathVariable String difficulty){
            return boardGameService.findDifficulty(difficulty);
        }
    }


