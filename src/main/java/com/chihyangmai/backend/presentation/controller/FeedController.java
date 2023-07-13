package com.chihyangmai.backend.presentation.controller;

import com.chihyangmai.backend.application.dto.FeedDto;
import com.chihyangmai.backend.application.service.FeedService;
import com.chihyangmai.backend.presentation.request.AddFeedRequest;
import com.chihyangmai.backend.presentation.response.FeedInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/feed")
    public ResponseEntity<Long> save (@RequestBody AddFeedRequest request) {
        Long savedId = feedService.addFeed(FeedDto.from(request));
        return ResponseEntity.ok(savedId);
    }

    @GetMapping("/feed")
    public ResponseEntity<List<FeedInfoResponse>> getAllFeeds () {
        List<FeedDto> allFeedDtoList = feedService.getAllFeeds();
        List<FeedInfoResponse> response = allFeedDtoList.stream().map(FeedInfoResponse::from).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/feed")
    public ResponseEntity<Void> deleteById (@RequestParam Long id) {
        feedService.deleteFeed(id);
        return ResponseEntity.ok(null);
    }





}
