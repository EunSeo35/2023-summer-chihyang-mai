package com.chihyangmai.backend.domain.entity;

import com.chihyangmai.backend.domain.entity.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE content SET deleted = true WHERE id = ?")
public class Content extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contentUrl;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private FundRequest fundRequest;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Feed feed;

    public static Content toContent (String imageUrl, Feed feed) {
        return Content.builder()
                .contentUrl(imageUrl)
                .feed(feed)
                .build();
    }

    public static Content toContent (String imageUrl, FundRequest fundRequest) {
        return Content.builder()
                .contentUrl(imageUrl)
                .fundRequest(fundRequest)
                .build();
    }

}
