package BoardGame.BackEnd.controller;


import BoardGame.BackEnd.dto.ReviewDto;
import BoardGame.BackEnd.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poyo")
@Log4j2
public class ReviewController {
    private final ReviewService service;

    @PostMapping("/review/{board_game_id}")
    public ResponseEntity<ReviewDto> insertReview(@RequestBody ReviewDto dto,@PathVariable Long board_game_id) throws Exception {
        return new ResponseEntity<>(service.insertReview(dto,board_game_id), HttpStatus.OK);
    }

    @GetMapping("/review/{board_game_id}")
    public ResponseEntity<List<ReviewDto>> selectReviewList(@PathVariable Long board_game_id) throws Exception {
        return new ResponseEntity<>(service.selectReviewList(board_game_id), HttpStatus.OK);
    }

    @DeleteMapping("/review/{review_id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long review_id) throws Exception {
        return new ResponseEntity<>(service.deleteReview(review_id), HttpStatus.OK);
    }

}
