package com.chihyangmai.backend.domain.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE room SET deleted = true WHERE id = ?")
public class FundRequest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String tag;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @JsonIgnore
    @OneToMany(mappedBy = "fundRequest", cascade = CascadeType.ALL)
    private List<Content> contentList = new ArrayList<>();
}
