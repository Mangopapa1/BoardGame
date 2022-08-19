package BoardGame.BackEnd.service;

import BoardGame.BackEnd.dto.BoardGameDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface BoardGameService {

    List<BoardGameDto> getAllGames();

    List<BoardGameDto> getTypeGames(String type);

    List<BoardGameDto> getDifficultyGames(String difficulty);

    List<BoardGameDto> getNameGame(String name);

    List<BoardGameDto> getPlayersGame(String players);

}
