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
//@Where(clause = "deleted = false")
//@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id = ?")
public class User {

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
