package BoardGame.BackEnd.Controller;

import BoardGame.BackEnd.Domain.Dto.ReviewDto;
import BoardGame.BackEnd.Domain.Entity.Review;
import BoardGame.BackEnd.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
@Log4j2
public class ReviewController {
    private final ReviewService service;

    @PostMapping("")
    public ResponseEntity<ReviewDto> insertReview(@RequestBody ReviewDto dto) throws Exception {
        return new ResponseEntity<>(service.insertReview(dto), HttpStatus.OK);
    }

    @GetMapping("/{work_book_id}")
    public ResponseEntity<List<ReviewDto>> selectReviewList(@PathVariable String board_game_id) throws Exception {
        return new ResponseEntity<>(service.selectReviewList(board_game_id), HttpStatus.OK);
    }

    @DeleteMapping("/{review_id}")
    public ResponseEntity<String> deleteReview(@PathVariable String review_id) throws Exception {
        return new ResponseEntity<>(service.deleteReview(review_id), HttpStatus.OK);
    }

}
