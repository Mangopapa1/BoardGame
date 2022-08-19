package BoardGame.BackEnd.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewDto {
    private Long reviewId;
    private String reviewPw;
    private String memberId;
    private Long boardGameId;
    private String replyContent;
    private Long reviewPoints;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}