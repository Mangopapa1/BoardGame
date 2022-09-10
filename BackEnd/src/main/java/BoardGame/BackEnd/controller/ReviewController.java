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

    @PostMapping("/review/{boardGameId}")
    public ResponseEntity<ReviewDto> insertReview(@RequestBody ReviewDto dto,@PathVariable Long boardGameId) throws Exception {
        return new ResponseEntity<>(service.insertReview(dto,boardGameId), HttpStatus.OK);
    }

    @GetMapping("/review/{boardGameId}")
    public ResponseEntity<List<ReviewDto>> selectReviewList(@PathVariable Long boardGameId) throws Exception {
        return new ResponseEntity<>(service.selectReviewList(boardGameId), HttpStatus.OK);
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) throws Exception {
        return new ResponseEntity<>(service.deleteReview(reviewId), HttpStatus.OK);
    }

}
