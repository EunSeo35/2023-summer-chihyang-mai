package com.chihyangmai.backend.presentation.request;

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
public class AddFeedRequest {

    private String content;

    private String tag;

    private Long writer_id;

    private List<String> image_urls = new ArrayList<>();

}
