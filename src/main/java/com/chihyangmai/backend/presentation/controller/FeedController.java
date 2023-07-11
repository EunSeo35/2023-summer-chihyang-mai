package com.chihyangmai.backend.presentation.controller;

import com.chihyangmai.backend.application.dto.FeedDto;
import com.chihyangmai.backend.application.service.FeedService;
import com.chihyangmai.backend.presentation.request.AddFeedRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FeedController {
    @Autowired
    private FeedService feedService;
    /**
     * Save feed*/

    @PostMapping("/feed")
    public ResponseEntity<Long> save (@RequestBody AddFeedRequest request) {
        Long savedId = feedService.addFeed(FeedDto.from(request));
        return ResponseEntity.ok(savedId);

    }



}
