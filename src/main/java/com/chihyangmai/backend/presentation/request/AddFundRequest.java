package com.chihyangmai.backend.presentation.request;

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

    private Long writerId;

    private String title;

    private String content;

    private String tag;

    private String influencer;

    private ArrayList<String> imageUrls;
}
