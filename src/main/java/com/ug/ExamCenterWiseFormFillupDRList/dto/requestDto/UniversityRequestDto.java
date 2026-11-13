package com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniversityRequestDto {

    private String university;

    private String examCenter;

    private String examCode;

    private String examination;

    private String totalCandidates;

}
