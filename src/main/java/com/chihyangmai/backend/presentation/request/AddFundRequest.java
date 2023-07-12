package com.chihyangmai.backend.presentation.request;

import com.chihyangmai.backend.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddFundRequest {
    private User writer;
    private Long writerId;
    private String title;
    private String request_num;
    private String content;
    private String tag;
    private String influencer;
    private ArrayList<String> imageUrls;
}
