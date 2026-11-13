package com.ug.ExamCenterWiseFormFillupDRList.mapper;

import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.SubjectRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.SubjectResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.entity.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toSubject(SubjectRequestDto subjectRequestDto);

    SubjectResponseDto toSubjectResponseDto(Subject subject);

    List<SubjectResponseDto> toSubjectResponseDtoList(List<Subject> subjects);

}
