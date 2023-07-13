package com.chihyangmai.backend.domain.entity;


import com.chihyangmai.backend.application.dto.FundRequestDto;
import com.chihyangmai.backend.domain.entity.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
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
    private String title;
    private String content;
    private String tag;
    private int request_num;
    private String influencer;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @JsonIgnore
    @OneToMany(mappedBy = "fundrequest", cascade = CascadeType.ALL)
    private List<Content> contentList = new ArrayList<>();

    @JsonIgnore
    @OneToOne
    private Feed feed;


    public static FundRequest toFund(FundRequestDto dto) {
        return FundRequest.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .tag(dto.getTag())
                .influencer(dto.getInfluencer())
                .content(dto.getContent())
                .build();
    }


}



