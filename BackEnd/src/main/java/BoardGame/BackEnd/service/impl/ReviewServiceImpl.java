package BoardGame.BackEnd.Service.impl;

import BoardGame.BackEnd.dto.ReviewDto;
import BoardGame.BackEnd.entity.Review;
import BoardGame.BackEnd.repository.ReviewRepository;
import BoardGame.BackEnd.service.ReviewService;
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
    public ReviewDto insertReview(ReviewDto dto,Long boardGameId) throws Exception {

        if (dto.getReplyContent().equals("")) {
            throw new Exception("내용을 입력해 주세요");
        }

//        Optional<WorkBook> workBook = workBookRepository.findById(work_book_id);
//        checkWorkBookEntity(workBook);
//        dto.setReviewPw(bCryptModule.encodePw(dto.setReviewPw()));
        Review entity = reviewRepository.save(dtoToEntity(dto,boardGameId));

        return entityToDto(entity);
    }

    @Override
    public String deleteReview(Long reviewId) throws Exception {
        Optional<Review> entity = reviewRepository.findById(reviewId);
        if (!entity.isPresent()) {
            throw new Exception("존재하지 않는 리뷰입니다.");
        }

        if (entity.get().getReviewId().equals(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return "삭제 완료";
        }
        return "삭제 실패 ex) 작성자가 다릅니다.";
    }

    @Override
    public List<ReviewDto> selectReviewList(Long boardGameId) {

        List<Review> entity = reviewRepository.findByBoardGameId(boardGameId);

        return entity.stream().map(data -> entityToDto(data)).collect(Collectors.toList());
    }

}
