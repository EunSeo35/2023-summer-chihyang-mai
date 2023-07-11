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
public class AddFeedRequest {

    private String content;

    private String tag;

    private Long writer_id;

    private ArrayList<String> image_urls;
}
