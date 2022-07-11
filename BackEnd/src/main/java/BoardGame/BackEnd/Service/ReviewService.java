package BoardGame.BackEnd.Service;

import BoardGame.BackEnd.Entity.Review;
import BoardGame.BackEnd.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    //리뷰 등록
    @Transactional
    public Long write(Review review){
        reviewRepository.save(review);
        return review.getReviewId();
    }

    //전체 조회
    public List<Review> findReviews(){
        return reviewRepository.findAll();
    }




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
