package com.wave.school.core.service;

import com.wave.school.core.Subject;
import com.wave.school.core.Teacher;
import com.wave.school.core.repository.SubjectRepository;
import com.wave.school.core.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject createSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    public Subject getSubjectById(Long subjectId){ return subjectRepository.findById(subjectId).orElse(null); }

    public Subject getSubjectByName(String name){ return subjectRepository.findByName(name); }

    public Subject updateSubject(Long subjectId, Subject updatedSubject){
        Subject existingSubject = getSubjectById(subjectId);
        if(existingSubject != null) {
            existingSubject.setName(updatedSubject.getName());
            return subjectRepository.save(existingSubject);
        }
        return null;
    }

    public void deleteSubject(Long subjectId){
        Subject existingSubject = getSubjectById(subjectId);
        if(existingSubject!= null){
            subjectRepository.delete(existingSubject);
        }
    }

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
}
