package com.wave.school.core.service;

import com.wave.school.core.Subject;
import com.wave.school.core.Teacher;
import com.wave.school.core.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher){ return teacherRepository.save(teacher); }
    public Teacher getTeacherById(Long teacherId){ return teacherRepository.findById(teacherId).orElse(null); }
    public Teacher getTeacherByName(String name){ return teacherRepository.findByFullName(name); }

    public Teacher updateTeacher(Long teacherId, Teacher updatedTeacher){
        Teacher existingTeacher = getTeacherById(teacherId);
        if(existingTeacher != null) {
            existingTeacher.setFullName(updatedTeacher.getFullName());
            return teacherRepository.save(existingTeacher);
        }
        return null;
    }

    public void deleteTeacher(Long teacherId){
        Teacher existingTeacher = getTeacherById(teacherId);
        if(existingTeacher != null){
            teacherRepository.delete(existingTeacher);
        }
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
}
