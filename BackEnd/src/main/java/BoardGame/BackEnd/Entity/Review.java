package BoardGame.BackEnd.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Builder
//@Data
//@Table(name = "review")

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}