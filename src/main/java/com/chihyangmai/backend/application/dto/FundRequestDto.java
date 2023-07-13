package com.chihyangmai.backend.application.dto;

import com.chihyangmai.backend.domain.entity.FundRequest;
import com.chihyangmai.backend.presentation.request.AddFundRequest;
import com.chihyangmai.backend.presentation.request.UpdateFundRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
//    private ArrayList<String> imageUrls;
    private List<String> imageUrlsStr = new ArrayList<>();
    private List<ContentDto> imageUrlsDto = new ArrayList<>();
    private LocalDateTime created_time;
    private LocalDateTime finished_time;


    public static FundRequestDto from(AddFundRequest request) {
        return FundRequestDto.builder()
                .writerId(request.getWriter_id())
                .title(request.getTitle())
                .content(request.getContent())
                .tag(request.getTag())
                .imageUrlsStr(request.getImage_urls())
                .influencer(request.getInfluencer())
                .build();
    }

    public static FundRequestDto toAdd(AddFundRequest request) {
        return FundRequestDto.builder()
                .writerId(request.getWriter_id())
                .title(request.getTitle())
                .content(request.getContent())
                .tag(request.getTag())
                .imageUrlsStr(request.getImage_urls())
                .influencer(request.getInfluencer())
                .imageUrlsStr(request.getImage_urls())
                .build();
    }

    public static FundRequestDto from (FundRequest fundRequest, List<ContentDto> contentDtoList) {
        return FundRequestDto.builder()
                .id(fundRequest.getId())
                .title(fundRequest.getTitle())
                .content(fundRequest.getContent())
                .tag(fundRequest.getTag())
                .created_time(fundRequest.getCreated_time())
                .finished_time(fundRequest.getCreated_time())
                .writerId(fundRequest.getWriter().getId())
                .writer(UserDto.from(fundRequest.getWriter()))
                .request_num(fundRequest.getRequest_num())
                .imageUrlsDto(contentDtoList)
                .build();
    }

    public static FundRequestDto toUpdate(UpdateFundRequest request) {
        return FundRequestDto.builder()
                .request_num(request.getRequest_num())
                .build();
    }
}
