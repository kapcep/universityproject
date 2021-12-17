package com.karpusha.university.controller;

import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleItemController {
    @Autowired
    StudentGroupService studentGroupService;


    @RequestMapping("/getAllScheduleItems")
    public String showAllScheduleItems(Model model) {

        return "all-schedule-items";
    }

    @RequestMapping("/testSchedulePage")
    public String showTest(Model model) {
        List<StudentGroup> studentGroups = new ArrayList<>();
        studentGroups.add(studentGroupService.getStudentGroup(1));
        studentGroups.add(studentGroupService.getStudentGroup(2));
        studentGroups.add(studentGroupService.getStudentGroup(3));

        model.addAttribute("studentGroups", studentGroups);
        return "test-schedule-page";
    }

}
