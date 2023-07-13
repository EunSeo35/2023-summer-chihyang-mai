package com.chihyangmai.backend.domain.entity;


import com.chihyangmai.backend.application.dto.FundRequestDto;
import com.chihyangmai.backend.domain.entity.common.BaseEntity;
import com.chihyangmai.backend.presentation.request.AddFundRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE fund_request SET deleted = true WHERE id = ?")
public class FundRequest extends BaseEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;
    private String title;
    private String content;
    private String tag;
    private int request_num;
    private String influencer;
//
//    private LocalDateTime created_time

    private LocalDateTime finished_time;

    @JsonIgnore
    @OneToMany(mappedBy = "fundRequest", cascade = CascadeType.ALL)
    private List<Content> contentList = new ArrayList<>();

    public static FundRequestDto from(AddFundRequest request) {
        return FundRequestDto.builder()
                .writerId(request.getWriter_id())
                .title(request.getTitle())
                .content(request.getContent())
                .tag(request.getTag())
                .influencer(request.getInfluencer())
//                .imageUrls(request.getImageUrls())
                .build();
    }

//    public static FundRequestDto toAdd(AddFundRequest request) {
//        return FundRequestDto.builder()
//                .writerId(request.getWriterId())
//                .title(request.getTitle())
//                .content(request.getContent())
//                .tag(request.getTag())
//                .influencer(request.getInfluencer())
////                .imageUrls(request.getImageUrls())
//                .build();
//    }

    public static FundRequest toFund(FundRequestDto dto, User user) {
        return FundRequest.builder()
                .title(dto.getTitle())
                .writer(user)
                .content(dto.getContent())
                .tag(dto.getTag())
                .influencer(dto.getInfluencer())
                .content(dto.getContent())
                .build();
    }


}



