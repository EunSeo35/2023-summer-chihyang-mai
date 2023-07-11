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

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long addFeed (FeedDto dto) {
        User user = userRepository.findById(dto.getWriterId()).orElseThrow(() -> new IllegalArgumentException("No such user"));
        Feed newFeed = feedRepository.save(Feed.toFeed(dto, user));
        //image url들을 각각 entity를 생성하여 저장한다
        List<Content> contentList = dto.getImageUrls().stream()
                .map(url -> Content.toContent(url, newFeed))
                .collect(Collectors.toList());
        newFeed.setContentList(contentList);

        return newFeed.getId();
    }

}