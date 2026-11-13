package com.ug.ExamCenterWiseFormFillupDRList.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;

    private String registration;

    private String name;

    private List<String> courseIds;

    private String checkedAnd;

    @ManyToOne
    @JsonIgnore
    private Subject subject;

}
