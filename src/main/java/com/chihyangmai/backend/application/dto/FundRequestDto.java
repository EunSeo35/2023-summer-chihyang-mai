package com.chihyangmai.backend.application.dto;

import com.chihyangmai.backend.presentation.request.AddFundRequest;
import com.chihyangmai.backend.presentation.request.UpdateFundRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundRequestDto {
    private Long id;
    private UserDto writer;
    private Long writerId;
    private String title;
    private String content;
    private String tag;
    private int request_num;
    private String influencer;
    private ArrayList<String> imageUrls;
    private LocalDateTime created_time;
    private LocalDateTime finished_time;


    public static FundRequestDto from(AddFundRequest request) {
        return FundRequestDto.builder()
                .writerId(request.getWriterId())
                .title(request.getTitle())
                .content(request.getContent())
                .tag(request.getTag())
                .influencer(request.getInfluencer())
                .imageUrls(request.getImageUrls())
                .created_time(LocalDateTime.now())
                .finished_time(null)
                .build();
    }

    public static FundRequestDto toAdd(AddFundRequest request) {
        return FundRequestDto.builder()
                .writerId(request.getWriterId())
                .title(request.getTitle())
                .content(request.getContent())
                .tag(request.getTag())
                .influencer(request.getInfluencer())
                .imageUrls(request.getImageUrls())
                .created_time(LocalDateTime.now())
                .finished_time(null)
                .build();
    }

    public static FundRequestDto toUpdate(UpdateFundRequest request) {
        return FundRequestDto.builder()
                .request_num(request.getRequest_num())
                .build();
    }
}
