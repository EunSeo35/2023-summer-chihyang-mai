package com.chihyangmai.backend.application.service;

import com.chihyangmai.backend.application.dto.ContentDto;
import com.chihyangmai.backend.application.dto.FeedDto;
import com.chihyangmai.backend.domain.entity.Content;
import com.chihyangmai.backend.domain.entity.Feed;
import com.chihyangmai.backend.domain.entity.User;
import com.chihyangmai.backend.domain.repository.FeedRepository;
import com.chihyangmai.backend.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        //Content와 Feed의 다대일 관계 형성
        List<Content> contentList = dto.getImageUrlsStr().stream()
                .map(url -> Content.toContent(url, newFeed))
                .collect(Collectors.toList());
        newFeed.setContentList(contentList);

        return newFeed.getId();
    }

    @Transactional
    public List<FeedDto> getAllFeeds() {
        List<Feed> allFeedList= feedRepository.findAll();
        List<FeedDto> allFeedDtoList = new ArrayList<>();
        //Feed의 List<Content>를 List<ContentDto>로 변환
        for (Feed f : allFeedList) {
            List<ContentDto> contentDtoList = f.getContentList().stream().map(ContentDto::from)
                    .collect(Collectors.toList());
            allFeedDtoList.add(FeedDto.from(f, contentDtoList));
        }

        return allFeedDtoList;
    }

    @Transactional
    public void deleteFeed (Long id) {
        System.out.println("Feed id = " + id);
        feedRepository.deleteById(id);
    }

}