package com.chihyangmai.backend.domain.entity;

import com.chihyangmai.backend.application.dto.FeedDto;
import com.chihyangmai.backend.domain.entity.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE feed SET deleted = true WHERE id = ?")
public class Feed extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String tag;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @JsonIgnore
    @OneToOne
    private FundRequest fundRequest;

    @JsonIgnore
    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private List<Content> contentList = new ArrayList<>();

    public static Feed toFeed (FeedDto dto, User user) {
        return Feed.builder()
                .content(dto.getContent())
                .tag(dto.getTag())
                .writer(user)
                .build();
    }



}
