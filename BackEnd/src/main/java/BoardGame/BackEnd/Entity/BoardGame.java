package BoardGame.BackEnd.Entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "board_game")
@Data
@Builder
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

    private String image;

    private String description;



}
