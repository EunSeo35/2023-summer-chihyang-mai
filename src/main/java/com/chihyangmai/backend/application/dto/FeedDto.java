package com.chihyangmai.backend.application.dto;

import com.chihyangmai.backend.presentation.request.AddFeedRequest;
import lombok.*;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedDto {

    private String content;

    private String tag;

    private Long writerId;

    private ArrayList<String> imageUrls;

    public static FeedDto from (AddFeedRequest request) {
        return FeedDto.builder()
                .content(request.getContent())
                .tag(request.getTag())
                .writerId(request.getWriterId())
                .imageUrls(request.getImageUrls())
                .build();
    }
}
