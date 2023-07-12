package com.chihyangmai.backend.application.dto;

import com.chihyangmai.backend.domain.entity.Fund;
import com.chihyangmai.backend.presentation.request.AddFundRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundDto {

    private Long writerId;

    private String title;

    private String content;

    private String tag;

    private String influencer;

    private ArrayList<String> imageUrls;

    public static FundDto from(AddFundRequest request) {
        return FundDto.builder()
                .writerId(request.getWriterId())
                .title(request.getTitle())
                .content(request.getContent())
                .tag(request.getTag())
                .influencer(request.getInfluencer())
                .imageUrls(request.getImageUrls())
                .build();
    }

    public static FundDto toAdd(AddFundRequest request) {
        return FundDto.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .tag(request.getTag())
                .influencer(request.getInfluencer())
                .imageUrls(request.getImageUrls())
                .build();
    }

}
