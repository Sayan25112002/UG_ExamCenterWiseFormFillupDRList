package com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponseDto {

    private Long id;

    private String subject;

    private String subjectType;

    private String semester;

    private String formFillupType;

}
