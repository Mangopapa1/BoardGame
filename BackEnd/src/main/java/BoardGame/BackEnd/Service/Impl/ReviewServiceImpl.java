package BoardGame.BackEnd.Service.Impl;

import BoardGame.BackEnd.Dto.ReviewDto;
import BoardGame.BackEnd.Entity.Review;
import BoardGame.BackEnd.Repository.ReviewRepository;
import BoardGame.BackEnd.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

//    private final BCryptModule bCryptModule;

    @Override
    public ReviewDto insertReview(ReviewDto dto,Long board_game_id) throws Exception {

        if (dto.getReplyContent().equals("")) {
            throw new Exception("내용을 입력해 주세요");
        }

//        Optional<WorkBook> workBook = workBookRepository.findById(work_book_id);
//        checkWorkBookEntity(workBook);
//        dto.setReviewPw(bCryptModule.encodePw(dto.setReviewPw()));
        Review entity = reviewRepository.save(dtoToEntity(dto,board_game_id));

        return entityToDto(entity);
    }

    @Override
    public String deleteReview(Long review_id) throws Exception {
        Optional<Review> entity = reviewRepository.findById(String.valueOf(review_id));
        if (!entity.isPresent()) {
            throw new Exception("존재하지 않는 리뷰입니다.");
        }

        if (entity.get().getReviewId().equals(review_id)) {
            reviewRepository.deleteById(String.valueOf(review_id));
            return "삭제 완료";
        }
        return "삭제 실패 ex) 작성자가 다릅니다.";
    }

    @Override
    public List<ReviewDto> selectReviewList(Long board_game_id) {

        List<Review> entity = reviewRepository.findByBoardGameId(String.valueOf(board_game_id));

        return entity.stream().map(data -> entityToDto(data)).collect(Collectors.toList());
    }

}
