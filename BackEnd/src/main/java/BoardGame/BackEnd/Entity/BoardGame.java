package BoardGame.BackEnd.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "board_game")
@Builder
@AllArgsConstructor
@Getter
public class BoardGame {

    @Id
    @GeneratedValue
    @Column(name = "board_game_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String players;

    @Column(name = "play_time")
    private String playTime;

    @Column
    private String category;

    @Column
    private String difficulty;

    @Column
    private String image;

    @Column
    private String description;

    public BoardGame() {
    }
}
