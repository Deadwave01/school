package com.wave.school.core.repository;

import com.wave.school.core.Subject;
import com.wave.school.core.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findByFullName(String name);
}
