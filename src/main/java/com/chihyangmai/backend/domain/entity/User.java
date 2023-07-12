package com.chihyangmai.backend.domain.entity;


import com.chihyangmai.backend.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private List<Feed> feedList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private List<FundRequest> fundRequestList = new ArrayList<>();
}
