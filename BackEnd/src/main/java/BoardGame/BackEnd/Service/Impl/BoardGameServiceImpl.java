package BoardGame.BackEnd.Service.Impl;

import BoardGame.BackEnd.Dto.BoardGameDto;
import BoardGame.BackEnd.Entity.BoardGame;
import BoardGame.BackEnd.Repository.BoardGameRepository;
import BoardGame.BackEnd.Service.BoardGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardGameServiceImpl implements BoardGameService {

    private final BoardGameRepository boardGameRepository;
    @Override
    public List<BoardGameDto> getAllGames() {
        return boardGameRepository.findAll().stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());

    }
    @Override
    public List<BoardGameDto> getTypeGames(String type) {
        return boardGameRepository.findByType(type).stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<BoardGameDto> getDifficultyGames(String difficulty) {
        return boardGameRepository.findByDifficulty(difficulty).stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<BoardGame> getNameGame(String name) {
        return boardGameRepository.findByNameStartingWith("name");
    }


}
