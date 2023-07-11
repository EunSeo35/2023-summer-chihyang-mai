package com.chihyangmai.backend.application.service;

import com.chihyangmai.backend.application.dto.FeedDto;
import com.chihyangmai.backend.domain.entity.Content;
import com.chihyangmai.backend.domain.entity.Feed;
import com.chihyangmai.backend.domain.entity.User;
import com.chihyangmai.backend.domain.repository.ContentRepository;
import com.chihyangmai.backend.domain.repository.FeedRepository;
import com.chihyangmai.backend.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long addFeed (FeedDto dto) {
        User user = userRepository.findById(dto.getWriterId()).orElseThrow(() -> new IllegalArgumentException("No such user"));
        Feed newFeed = feedRepository.save(Feed.toFeed(dto, user));
        return newFeed.getId();
    }

}