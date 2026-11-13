package com.ug.ExamCenterWiseFormFillupDRList.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private String subjectType;

    private String semester;

    private String formFillupType;

    @ManyToOne
    @JsonIgnore
    private University university;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore
    private List<Student> students;

}
