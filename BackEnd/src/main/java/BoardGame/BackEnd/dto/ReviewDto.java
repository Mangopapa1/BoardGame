package BoardGame.BackEnd.dto;

import lombok.*;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class ReviewDto {
    private Long reviewId;
    private String reviewPw;
    private String memberId;
    private String replyContent;
    private Long reviewPoints;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}