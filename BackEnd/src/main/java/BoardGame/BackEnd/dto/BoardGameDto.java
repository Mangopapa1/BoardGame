package BoardGame.BackEnd.dto;

import BoardGame.BackEnd.entity.BoardGame;
import BoardGame.BackEnd.entity.Review;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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
    private List<Review> reviews;

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
