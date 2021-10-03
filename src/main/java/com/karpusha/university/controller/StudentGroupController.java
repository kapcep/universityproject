package com.karpusha.university.controller;

import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentGroupController {

    @Autowired
    StudentGroupService studentGroupService;

    @RequestMapping("/getAllStudentGroups")
    public String showAllStudentGroups(Model model) {
        List<StudentGroup> allStudentGroups = studentGroupService.getAllStudentGroups();
        model.addAttribute("allStudentGroups", allStudentGroups);

        return "all-student-groups";
    }

}
