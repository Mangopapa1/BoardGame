package BoardGame.BackEnd.controller;

import BoardGame.BackEnd.dto.BoardGameDto;
import BoardGame.BackEnd.service.impl.BoardGameServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poyo")
@Tag(name = "poyo", description = "poyo API")
public class BoardGameApiController {

    private final BoardGameServiceImpl boardGameService;




    @Operation(summary = "모든 게임 조회", description = "모든 게임 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/games") //모든게임조회
    public List<BoardGameDto> AllGames(){
        return boardGameService.getAllGames();
    }




    @Operation(summary = "보드게임 이름 검색")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/search/name/{name}") //이름
    public List<BoardGameDto> searchName(@Parameter(description = "보드게임이름", required = true, example = "카탄, 테라") @PathVariable String name){
        return boardGameService.getNameGame(name);
    }

    @Operation(summary = "보드게임 장르 검색")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/search/type/{type}") //장르별
    public List<BoardGameDto> searchType(@Parameter(description = "보드게임장르", required = true, example = "전략, 카드") @PathVariable String type){
        return boardGameService.getTypeGames(type);

    }

    @Operation(summary = "보드게임 난이도 검색")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/search/difficulty/{difficulty}") //난이도
    public List<BoardGameDto> searchDifficulty(@Parameter(description = "보드게임 난이도", required = true, example = "입문, 초급") @PathVariable String difficulty){
        return boardGameService.getDifficultyGames(difficulty);
    }


    @Operation(summary = "최소인원수 검색")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/search/player/{MinPlayer}") //인원수
    public List<BoardGameDto> searchMinPlayers(@Parameter(description = "최소인원수", required = true, example = "2, 숫자만") @PathVariable Integer player){
        return boardGameService.getMinPlayer(player);
    }


    @Operation(summary = "최소인원수 검색")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/search/player/{MaxPlayer}")
    public List<BoardGameDto> searchMaxPlayer(@Parameter(description = "최대인원수", required = true, example = "5, 숫자만") @PathVariable Integer player){
        return boardGameService.getMaxPlayer(player);
    }

    }


