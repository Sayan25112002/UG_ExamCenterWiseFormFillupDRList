package com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniversityResponseDto {

    private Long id;

    private String university;

    private String examCenter;

    private String examCode;

    private String examination;

    private List<SubjectResponseDto> subjects;

}
