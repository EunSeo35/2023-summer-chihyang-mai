package com.chihyangmai.backend.application.dto;

import com.chihyangmai.backend.domain.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ContentDto {
    private String image_url;
    public static ContentDto from (Content content) {
        return ContentDto.builder()
                .image_url(content.getContentUrl())
                .build();
    }
}
