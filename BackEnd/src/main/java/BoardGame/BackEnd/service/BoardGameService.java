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

    List<BoardGameDto> getMinPlayer(int player);

    List<BoardGameDto> getMaxPlayer(int player);

    List<BoardGameDto> getId(Long id);

}
