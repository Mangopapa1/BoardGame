package BoardGame.BackEnd.service.impl;

import BoardGame.BackEnd.dto.BoardGameDto;
import BoardGame.BackEnd.repository.BoardGameRepository;
import BoardGame.BackEnd.service.BoardGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        return boardGameRepository.findByTypeContaining(type).stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<BoardGameDto> getDifficultyGames(String difficulty) {
        return boardGameRepository.findByDifficultyContaining(difficulty).stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<BoardGameDto> getNameGame(String name) {
        return boardGameRepository.findByNameContaining(name).stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<BoardGameDto> getMinPlayer(int MinPlayer) {
        return boardGameRepository.findByMinPlayer(MinPlayer).stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<BoardGameDto> getMaxPlayer(int MaxPlayer) {
        return boardGameRepository.findByMaxPlayer(MaxPlayer).stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<BoardGameDto> getId(Long id) {
        return boardGameRepository.findById(id).stream().map(BoardGameDto::fromEntity).collect(Collectors.toList());
    }


}
