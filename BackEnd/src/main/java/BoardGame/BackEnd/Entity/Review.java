package BoardGame.BackEnd.Entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "review")
@Builder
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "review_pw")
    private String reviewPw;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "board_game_id")
    private Long boardGameId;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "modified_date")
    private String modifiedDate;
}
