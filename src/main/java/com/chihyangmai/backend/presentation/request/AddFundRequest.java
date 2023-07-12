package com.chihyangmai.backend.presentation.request;

import com.chihyangmai.backend.application.dto.UserDto;
import com.chihyangmai.backend.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddFundRequest {
    private User writer;
    private Long writerId;
    private String title;
    private String content;
    private String tag;
    private String influencer;
    private ArrayList<String> imageUrls;
}
