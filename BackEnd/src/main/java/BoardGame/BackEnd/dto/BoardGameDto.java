package BoardGame.BackEnd.dto;

import BoardGame.BackEnd.entity.BoardGame;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardGameDto {

    private Long id;
    private String name;
    private String playTime;
    private Integer MinPlayer;
    private Integer MaxPlayer;
    private String type;
    private String difficulty;
    private String description;
    private String image;

    public static BoardGameDto fromEntity(BoardGame boardGame){
        return BoardGameDto.builder()
                .id(boardGame.getId())
                .name(boardGame.getName())
                .playTime(boardGame.getPlayTime())
                .MinPlayer(boardGame.getMinPlayer())
                .MaxPlayer(boardGame.getMaxPlayer())
                .type(boardGame.getType())
                .difficulty(boardGame.getDifficulty())
                .description(boardGame.getDescription())
                .image(boardGame.getImage())
                .build();
    }

}
