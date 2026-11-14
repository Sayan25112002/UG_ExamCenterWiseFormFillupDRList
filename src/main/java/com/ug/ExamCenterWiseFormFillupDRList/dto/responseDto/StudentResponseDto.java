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
public class StudentResponseDto {

    private Long id;

    private String uid;

    private String registration;

    private String name;

    private List<String> courseIds;

    private String checkedAnd;

}
