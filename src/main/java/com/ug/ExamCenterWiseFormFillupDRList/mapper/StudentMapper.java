package com.ug.ExamCenterWiseFormFillupDRList.mapper;

import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.StudentRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.StudentResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.entity.Student;
import com.ug.ExamCenterWiseFormFillupDRList.entity.University;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toStudent(StudentRequestDto studentRequestDto);

    StudentResponseDto toStudentResponseDto(Student student);

    List<StudentResponseDto> toStudentResponseDtoList(List<Student> students);

}
