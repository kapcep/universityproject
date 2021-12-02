package com.karpusha.university.controller;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.service.DepartmentService;
import com.karpusha.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getAllTeachers")
    public String showAllTeachers(Model model) {
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        model.addAttribute("allTeachers", allTeachers);
        return "all-teachers";
    }

    @RequestMapping("/addNewTeacher/{groupId}")
    public String addNewTeacher(@PathVariable("groupId")
                                        int departmentId, Model model) {
        Teacher teacher = new Teacher();
        Department department = departmentService.getDepartment(departmentId);
        model.addAttribute("department", department);
        model.addAttribute("teacher", teacher);
        return "add-teacher";
    }
}
