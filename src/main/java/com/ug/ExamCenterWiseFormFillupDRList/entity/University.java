package com.ug.ExamCenterWiseFormFillupDRList.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String university;

    private String examCenter;

    private String examCode;

    private String examination;

    @OneToMany(mappedBy = "university")
    @JsonIgnore
    private List<Subject> subjects;

    private String totalCandidates;

}
