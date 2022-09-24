package BoardGame.BackEnd.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@SequenceGenerator(
        name="REVIEW_SEQ_GEN",
        sequenceName="REVIEW_SEQ",
        initialValue=1,
        allocationSize=1
)

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class Review {
    @Id
    @GeneratedValue(
            strategy=GenerationType.AUTO,
            generator="REVIEW_SEQ_GEN"
    )
    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "review_pw")
    @NotBlank
    private String reviewPw;

    @Column(name = "member_id")
    @NotBlank
    private String memberId;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "board_game_id")
    BoardGame boardGame;

    @Column(name = "reply_content")
    @NotNull
    private String replyContent;

    @Column(name = "review_points")
    @Min(1)
    private Long reviewPoints;

    @CreatedDate
    @Column(name = "created_date", updatable =false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;


}
