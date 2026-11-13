package com.ug.ExamCenterWiseFormFillupDRList.repository;

import com.ug.ExamCenterWiseFormFillupDRList.entity.Subject;
import com.ug.ExamCenterWiseFormFillupDRList.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {
    List<Subject> findBySubjects(List<Subject> subjects);
}
