package com.ug.ExamCenterWiseFormFillupDRList.mapper;

import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.UniversityRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.UniversityResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.entity.University;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UniversityMapper {

    University toUniversity(UniversityRequestDto universityRequestDto);

    UniversityResponseDto toUniversityResponseDto(University university);

    List<UniversityResponseDto> toUniversityResponseDtoList(List<University> universities);

}
