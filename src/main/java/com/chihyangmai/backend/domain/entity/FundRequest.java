package com.chihyangmai.backend.domain.entity;

import com.chihyangmai.backend.application.dto.FundDto;
import com.chihyangmai.backend.application.dto.UserDto;
import com.chihyangmai.backend.domain.BaseEntity;
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
@SQLDelete(sql = "UPDATE fund SET deleted = true WHERE id = ?")
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
    private LocalDateTime created_time;
    private LocalDateTime finished_time;
    private String influencer;

    @JsonIgnore
    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private List<Content> contentList = new ArrayList<>();

    public static FundRequest toFund(FundDto dto, User user) {
        return FundRequest.builder()
                .writer(user)
                .title(dto.getTitle())
                .content(dto.getContent())
                .tag(dto.getTag())
                .request_num(dto.getRequest_num())
                .influencer(dto.getInfluencer())
                .contentList(dto.getContent())
                .build();
    }

    public static FundDto from(FundRequest fundRequest) {
        return FundDto.builder()
                .writerId(fundRequest.getId())
                .title(fundRequest.getTitle())
                .content(fundRequest.getContent())
                .tag(fundRequest.getTag())
                .request_num(fundRequest.getRequest_num())
                .influencer(fundRequest.getInfluencer())
                .imageUrls(fundRequest.getImageUrls())
                .build();
    }


}



