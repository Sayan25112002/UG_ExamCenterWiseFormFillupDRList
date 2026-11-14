package com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectResponseDto {

    private Long id;

    private String subject;

    private String subjectType;

    private String semester;

    private String formFillupType;

    private List<StudentResponseDto> students;

}
