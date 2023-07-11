package com.chihyangmai.backend.domain.entity;

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
@SQLDelete(sql = "UPDATE room SET deleted = true WHERE id = ?")
public class Content {

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

    public static Content toContent (String imageUrl) {
        return Content.builder()
                .contentUrl(imageUrl)
                .build();
    }
}
