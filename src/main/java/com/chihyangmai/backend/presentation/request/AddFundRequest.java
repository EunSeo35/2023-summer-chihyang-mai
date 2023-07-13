package com.chihyangmai.backend.presentation.request;

import com.chihyangmai.backend.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddFundRequest {
    private Long writer_id;
    private String title;
    private String content;
    private String tag;
    private String influencer;
    private List<String> image_urls = new ArrayList<>();

}
