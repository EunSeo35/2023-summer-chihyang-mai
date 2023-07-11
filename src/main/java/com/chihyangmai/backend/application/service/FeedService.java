package com.chihyangmai.backend.application.service;

import com.chihyangmai.backend.application.dto.FeedDto;
import com.chihyangmai.backend.domain.entity.Feed;
import com.chihyangmai.backend.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    /*
    @Transactional
    public Long addFeed (FeedDto dto) {
        Feed newFeed = feedRepository.save()
    }
     */
}