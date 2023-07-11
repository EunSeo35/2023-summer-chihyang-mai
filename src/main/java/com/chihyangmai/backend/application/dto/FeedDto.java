package com.chihyangmai.backend.application.dto;

import com.chihyangmai.backend.domain.entity.Content;
import com.chihyangmai.backend.domain.entity.Feed;
import com.chihyangmai.backend.presentation.request.AddFeedRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedDto {

    private Long id;

    private String content;

    private String tag;

    private Long writerId;

    private List<String> imageUrls = new ArrayList<>();

    private LocalDateTime created_time;

    public static FeedDto from (AddFeedRequest request) {
        return FeedDto.builder()
                .content(request.getContent())
                .tag(request.getTag())
                .writerId(request.getWriter_id())
                .imageUrls(request.getImage_urls())
                .build();
    }

    public static FeedDto from (Feed feed, List<String> urls) {
        return FeedDto.builder()
                .id(feed.getId())
                .content(feed.getContent())
                .tag(feed.getTag())
                .created_time(feed.getCreated_time())
                .writerId(feed.getWriter().getId())
                .imageUrls(urls)
                .build();
    }
}
