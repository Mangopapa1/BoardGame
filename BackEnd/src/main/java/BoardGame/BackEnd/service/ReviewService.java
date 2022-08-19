package BoardGame.BackEnd.service;

import BoardGame.BackEnd.dto.ReviewDto;
import BoardGame.BackEnd.entity.BoardGame;
import BoardGame.BackEnd.entity.Review;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public interface ReviewService {


    ReviewDto insertReview(ReviewDto dto,Long board_game_id) throws Exception;

    String deleteReview(Long review_id) throws Exception;

    List<ReviewDto> selectReviewList(Long board_game_id) throws Exception;

    default Review dtoToEntity(ReviewDto dto,Long board_game_id) {
        BoardGame boardGameId = BoardGame.builder()
                .id(board_game_id)
                .build();
        return Review.builder()
                .memberId(dto.getMemberId())
                .reviewPw(dto.getReviewPw())
                .replyContent(dto.getReplyContent())
                .boardGameId(boardGameId)
                .build();
    }

    default ReviewDto entityToDto(Review entity) {
        return ReviewDto.builder()
                .reviewId(entity.getReviewId())
                .memberId(entity.getMemberId())
                .replyContent(entity.getReplyContent())
                .createdDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }

}
