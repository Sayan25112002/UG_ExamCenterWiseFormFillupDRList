package com.ug.ExamCenterWiseFormFillupDRList.repository;

import com.ug.ExamCenterWiseFormFillupDRList.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
