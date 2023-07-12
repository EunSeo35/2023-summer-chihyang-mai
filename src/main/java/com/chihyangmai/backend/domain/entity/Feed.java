package com.chihyangmai.backend.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import javax.persistence.*;
import java.util.ArrayList;

public class Feed {


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

}
