package com.chihyangmai.backend.presentation.response;

import com.chihyangmai.backend.application.dto.FundDto;
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
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        private LocalDateTime created_time;
        private LocalDateTime finished_time;
        private List<String> image_urls = new ArrayList<>();

        public static FundInfoResponse from (FundDto dto) {
            return FundInfoResponse.builder()
                    .id(dto.getId())
                    .writer(dto.getWriter())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .tag(dto.getTag())
                    .requested_num(dto.getRequest_num())
                    .created_time(dto.getCreated_time())
                    .finished_time(dto.getFinished_time())
                    .image_urls(dto.getImageUrls())
                    .build();
        }

}
