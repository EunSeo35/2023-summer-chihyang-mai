package com.chihyangmai.backend.presentation.response;

import com.chihyangmai.backend.application.dto.ContentDto;
import com.chihyangmai.backend.application.dto.FeedDto;
import com.chihyangmai.backend.application.dto.FundRequestDto;
import com.chihyangmai.backend.application.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FundInfoResponse {
        private Long id;
        private UserDto writer;
        private String title;
        private String content;
        private String tag;
        private int requested_num;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime created_time;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime finished_time;
        private String influencer;
        private List<ContentDto> image_urls = new ArrayList<>();

        public static FundInfoResponse from (FundRequestDto dto) {
            return FundInfoResponse.builder()
                    .id(dto.getId())
                    .writer(dto.getWriter())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .influencer(dto.getInfluencer())
                    .tag(dto.getTag())
                    .requested_num(dto.getRequest_num())
                    .created_time(dto.getCreated_time())
                    .finished_time(dto.getFinished_time())
                    .image_urls(dto.getImageUrlsDto())
                    .build();
        }

}
