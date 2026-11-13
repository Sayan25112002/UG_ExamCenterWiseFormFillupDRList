package com.ug.ExamCenterWiseFormFillupDRList.repository;

import com.ug.ExamCenterWiseFormFillupDRList.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
