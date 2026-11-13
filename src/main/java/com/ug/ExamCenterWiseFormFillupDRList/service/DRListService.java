package com.ug.ExamCenterWiseFormFillupDRList.service;

import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.StudentRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.SubjectRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.UniversityRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.StudentResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.SubjectResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.UniversityResponseDto;
import net.sf.jasperreports.engine.JRException;

import java.util.List;

public interface DRListService {

    UniversityResponseDto createUniversity(UniversityRequestDto universityRequestDto);

    SubjectResponseDto createSubject(SubjectRequestDto subjectRequestDto, Long universityId);

    StudentResponseDto createStudent(StudentRequestDto studentRequestDto, Long subjectId);

    List<UniversityResponseDto> getAllUniversity();

    byte[] generateDR(Long id) throws JRException;

}
