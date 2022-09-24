package BoardGame.BackEnd.service;

import BoardGame.BackEnd.dto.ReviewDto;
import BoardGame.BackEnd.entity.BoardGame;
import BoardGame.BackEnd.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {


    ReviewDto insertReview(ReviewDto dto,Long boardGameId) throws Exception;


    String deleteReview(Long review_id) throws Exception;

    List<ReviewDto> selectReviewList(Long boardGameId) throws Exception;

    ReviewDto updateReview(ReviewDto dto, Long boardGameId) throws Exception;


    default Review dtoToEntity(ReviewDto dto,Long boardGameId) {
        BoardGame getBoardGameId = BoardGame.builder()
                .id(boardGameId)
                .build();
        return Review.builder()
                .memberId(dto.getMemberId())
                .reviewPw(dto.getReviewPw())
                .replyContent(dto.getReplyContent())
                .reviewPoints(dto.getReviewPoints())
                .boardGame(getBoardGameId)
                .build();
    }

    default ReviewDto entityToDto(Review entity) {
        return ReviewDto.builder()
                .reviewId(entity.getReviewId())
                .reviewPw(entity.getReviewPw())
                .memberId(entity.getMemberId())
                .replyContent(entity.getReplyContent())
                .reviewPoints(entity.getReviewPoints())
                .createdDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }

//    default Review updateDtoToEntity(ReviewDto dto, Long boardGameId){
//
//
//        return Review.builder()
//                .memberId(dto.getMemberId())
//                .reviewPw(dto.getReviewPw())
//                .replyContent(dto.getReplyContent())
//                .reviewPoints(dto.getReviewPoints())
//
//                .build();
//    }

   default ReviewDto updateEntityToDto(Review review){
        return ReviewDto.builder()
                .memberId(review.getMemberId())
                .reviewPw(review.getReviewPw())
                .replyContent(review.getReplyContent())
                .reviewPoints(review.getReviewPoints())
                .build();


    }

}
