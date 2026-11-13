package com.ug.ExamCenterWiseFormFillupDRList.service.implementation;

import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.StudentRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.SubjectRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.requestDto.UniversityRequestDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.StudentResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.SubjectResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.dto.responseDto.UniversityResponseDto;
import com.ug.ExamCenterWiseFormFillupDRList.entity.Student;
import com.ug.ExamCenterWiseFormFillupDRList.entity.Subject;
import com.ug.ExamCenterWiseFormFillupDRList.entity.University;
import com.ug.ExamCenterWiseFormFillupDRList.mapper.StudentMapper;
import com.ug.ExamCenterWiseFormFillupDRList.mapper.SubjectMapper;
import com.ug.ExamCenterWiseFormFillupDRList.mapper.UniversityMapper;
import com.ug.ExamCenterWiseFormFillupDRList.repository.StudentRepository;
import com.ug.ExamCenterWiseFormFillupDRList.repository.SubjectRepository;
import com.ug.ExamCenterWiseFormFillupDRList.repository.UniversityRepository;
import com.ug.ExamCenterWiseFormFillupDRList.service.DRListService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DRListServiceImpl implements DRListService {

    private final UniversityRepository universityRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final UniversityMapper universityMapper;
    private final StudentMapper studentMapper;
    private final SubjectMapper subjectMapper;

    @Override
    public UniversityResponseDto createUniversity(UniversityRequestDto universityRequestDto) {
        University university = universityMapper.toUniversity(universityRequestDto);
        return universityMapper.toUniversityResponseDto(universityRepository.save(university));
    }

    @Override
    public SubjectResponseDto createSubject(SubjectRequestDto subjectRequestDto, Long universityId) {
        Subject subject = subjectMapper.toSubject(subjectRequestDto);
        University university = universityRepository.findById(universityId).orElseThrow(()->new EntityNotFoundException("University Not Found with id: " + universityId));
        university.getSubjects().add(subject);
        subject.setUniversity(university);
        return subjectMapper.toSubjectResponseDto(subjectRepository.save(subject));
    }

    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto, Long subjectId) {
        Student student = studentMapper.toStudent(studentRequestDto);
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(()->new EntityNotFoundException("Subject Not Found with id: " + subjectId));
        subject.getStudents().add(student);
        student.setSubject(subject);
        return studentMapper.toStudentResponseDto(studentRepository.save(student));
    }

    @Override
    public List<UniversityResponseDto> getAllUniversity() {
        return universityMapper.toUniversityResponseDtoList(universityRepository.findAll());
    }

    @Override
    public byte[] generateDR(Long id) throws JRException {
        String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\report\\";
        Path drPath = Paths.get(filePath,"ExamCenterWiseFormFillupDRList.jrxml");
        Path subjectPath = Paths.get(filePath,"Subject.jrxml");
        JasperReport drReport = JasperCompileManager.compileReport(drPath.toAbsolutePath().toString());
        JasperReport subjectReport = JasperCompileManager.compileReport(subjectPath.toAbsolutePath().toString());
        University university = universityRepository.findById(id).orElseThrow(()->new EntityNotFoundException("University Not Found with id: " + id));
        JRBeanCollectionDataSource universityDataSource = new JRBeanCollectionDataSource(Collections.singletonList(university));
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("subjectReport",subjectReport);
        JasperPrint print = JasperFillManager.fillReport(drReport,parameters,universityDataSource);
        return JasperExportManager.exportReportToPdf(print);
    }
}
