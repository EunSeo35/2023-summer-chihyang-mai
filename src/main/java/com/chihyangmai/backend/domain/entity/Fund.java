package com.chihyangmai.backend.domain.entity;

import com.chihyangmai.backend.application.dto.FundDto;
import com.chihyangmai.backend.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fund extends BaseEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long writerId;

    private String title;

    private String content;

    private String tag;

    private String influencer;

    private ArrayList<String> imageUrls;

    public static Fund toFund(FundDto dto) {
        return Fund.builder()
                .writerId(dto.getWriterId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .tag(dto.getTag())
                .influencer(dto.getInfluencer())
                .imageUrls(dto.getImageUrls())
                .build();
    }

}



