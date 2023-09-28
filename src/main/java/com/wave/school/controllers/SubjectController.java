package com.wave.school.controllers;

import com.wave.school.core.Subject;
import com.wave.school.core.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/subject-list/create-subject")
    public String createSubject(@RequestParam("subjectName") String subjectName){
        Subject existingSubject = subjectService.getSubjectByName(subjectName);
        if(existingSubject == null) {
            Subject subject = new Subject();
            subject.setName(subjectName);
            subjectService.createSubject(subject);
        }
        return "redirect:/subject-list";
    }

    @GetMapping("/subject-list")
    public String showSubjectList(Model model){
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subject-list";
    }

}
