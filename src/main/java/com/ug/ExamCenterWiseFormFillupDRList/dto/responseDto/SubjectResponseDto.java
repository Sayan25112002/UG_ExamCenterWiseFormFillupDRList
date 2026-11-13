package com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectResponseDto {

    private Long id;

    private String uid;

    private String registration;

    private String name;

    private List<String> courseIds;

    private String checkedAnd;

    private List<StudentResponseDto> students;

}
