package com.ug.ExamCenterWiseFormFillupDRList.controller;

import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.StudentRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.SubjectRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.UniversityRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.StudentResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.SubjectResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.UniversityResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.entity.University;
import com.ug.ExamCenterWiseFormFillupDRList.service.DRListService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DRListController {

    private final DRListService drListService;

    @PostMapping("/createUniversity")
    public UniversityResponseDto createUniversity(@RequestBody UniversityRequestDto university){
        return drListService.createUniversity(university);
    }

    @PostMapping("/createSubject")
    public SubjectResponseDto createSubject(@RequestBody SubjectRequestDto subject, @RequestParam Long universityId){
        return drListService.createSubject(subject,universityId);
    }

    @PostMapping("/createStudent")
    public StudentResponseDto createStudent(@RequestBody StudentRequestDto student, @RequestParam Long subjectId){
        return drListService.createStudent(student,subjectId);
    }

    @GetMapping("/getAllUniversities")
    public List<UniversityResponseDto> getAllUniversities(){
        return drListService.getAllUniversity();
    }

    @GetMapping("/generateDR")
    public HttpEntity<byte[]> generateDR(@RequestParam Long universityId) throws JRException {
        byte[] drSheet = drListService.generateDR(universityId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("application","DR Sheet.pdf");
        return new HttpEntity<>(drSheet,headers);
    }
}
