package BoardGame.BackEnd.Service;

import BoardGame.BackEnd.Dto.BoardGameDto;
import BoardGame.BackEnd.Entity.BoardGame;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface BoardGameService {

    List<BoardGameDto> getAllGames();

    List<BoardGameDto> getTypeGames(String type);

    List<BoardGameDto> getDifficultyGames(String difficulty);

    Optional<BoardGame> getNameGame(String name);

}
