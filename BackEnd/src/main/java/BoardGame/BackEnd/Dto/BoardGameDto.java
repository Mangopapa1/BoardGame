package BoardGame.BackEnd.Dto;

import BoardGame.BackEnd.Entity.BoardGame;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardGameDto {

    private String name;
    private String playTime;
    private String players;
    private String type;
    private String difficulty;
    private String description;
    private String image;

    public static BoardGameDto fromEntity(BoardGame boardGame){
        return BoardGameDto.builder()
                .name(boardGame.getName())
                .playTime(boardGame.getPlayTime())
                .players(boardGame.getPlayers())
                .type(boardGame.getType())
                .difficulty(boardGame.getDifficulty())
                .description(boardGame.getDescription())
                .build();
    }

}
