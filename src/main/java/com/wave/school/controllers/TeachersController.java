package com.wave.school.controllers;

import com.wave.school.core.Subject;
import com.wave.school.core.Teacher;
import com.wave.school.core.service.SubjectService;
import com.wave.school.core.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeachersController {
    private final TeacherService teacherService;

    @Autowired
    public TeachersController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping("/teachers-list/create-teacher")
    public String createTeacher(@RequestParam("teacherName") String fullName){
        Teacher existingTeacher = teacherService.getTeacherByName(fullName);
        if(existingTeacher == null) {
            Teacher teacher = new Teacher();
            teacher.setFullName(fullName);
            teacherService.createTeacher(teacher);
        }
        return "redirect:/teachers-list";
    }

    @GetMapping("/teachers-list")
    public String showTeacherList(Model model){
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers-list";
    }
}
