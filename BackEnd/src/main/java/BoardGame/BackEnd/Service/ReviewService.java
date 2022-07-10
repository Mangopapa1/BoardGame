package BoardGame.BackEnd.Service;

import BoardGame.BackEnd.Dto.ReviewDto;
import BoardGame.BackEnd.Entity.BoardGame;
import BoardGame.BackEnd.Entity.Review;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public interface ReviewService {


    ReviewDto insertReview(ReviewDto dto) throws Exception;

    String deleteReview(String review_id) throws Exception;

    List<ReviewDto> selectReviewList(String board_game_id) throws Exception;

    default Review dtoToEntity(ReviewDto dto) {
        BoardGame boardGameId = BoardGame.builder()
                .boardGameId(dto.getBoardGameId())
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
                .boardGameId(entity.getBoardgameId())
                .createdDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }

//    private final ReviewRepository reviewRepository;
//
//    //리뷰 등록
//    @Transactional
//    public Long write(ReviewDto review){
//        reviewRepository.save(review);
//        return review.getReviewId();
//    }
//
//    //전체 조회
//    public List<ReviewDto> findReviews(){
//        return reviewRepository.findAll();
//    }




//    @Transactional
//    public Long review(Long reviewId){

//        ReviewDTO reviewDTO = new ReviewDTO();
//        reviewDTO.setReviewId(reviewId);
//
//        /*
//        * 리뷰 삭제
//        * */
//        public void delete(Long reviewId){
//            //주문 엔티티 조회
//            Review review = reviewDTO.findOne(reviewId);
//            //주문 취소
//            review.delete();
//
//
//        }
//    }
}
