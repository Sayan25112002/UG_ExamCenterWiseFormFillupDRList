package com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectRequestDto {

    private String subject;

    private String subjectType;

    private String semester;

    private String formFillupType;

}
