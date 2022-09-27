package BoardGame.BackEnd.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @Column(name = "min_player")
    private Integer minPlayer;

    @Column(name = "max_player")
    private Integer maxPlayer;

    @Column(name = "play_time")
    private String playTime;

    @Column
    private String type;

    @Column
    private String difficulty;

    @Column
    private String image;

    @Column
    private String description;

    @OneToMany(mappedBy = "boardGame")
    private Set<Review> reviews = new LinkedHashSet<>();

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }


    public BoardGame() {

    }
}
