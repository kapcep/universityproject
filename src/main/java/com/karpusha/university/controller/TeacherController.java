package com.karpusha.university.controller;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.service.DepartmentService;
import com.karpusha.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/addNewTeacher/{departmentId}")
    public String addNewTeacher(@PathVariable("departmentId")
                                        int departmentId, Model model) {
        Teacher teacher = new Teacher();
        Department department = departmentService.getDepartment(departmentId);
        model.addAttribute("department", department);
        model.addAttribute("teacher", teacher);
        return "add-teacher";
    }

    @RequestMapping("/saveTeacher/{departmentId}")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher,
                              @PathVariable("departmentId")
                                      int departmentId, Model model) {
        teacherService.saveTeacher(teacher, departmentId);
        return "redirect:/editDepartment/" + departmentId;
    }

    @GetMapping("/editTeacher/{teacherId}")
    public String showTeacherUpdateForm(@PathVariable("teacherId")
                                                int teacherId, Model model) {
        Teacher teacher = teacherService.getTeacher(teacherId);
        int departmentId = teacher.getDepartment().getId();
        model.addAttribute("teacher", teacher);
        model.addAttribute("departmentId", departmentId);

        return "update-teacher";
    }

    @PostMapping("/updateTeacher/{departmentId}/{teacherId}")
    public String updateTeacher(@PathVariable("departmentId") int departmentId,
                                @PathVariable("teacherId") int teacherId,
                                @ModelAttribute("teacher") Teacher teacher, Model model) {
        teacher.setId(teacherId);
        teacherService.saveTeacher(teacher, departmentId);
        model.addAttribute("teacher", teacher);
        return "redirect:/editTeacher/" + teacherId;
    }

    @GetMapping("/deleteTeacher/{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId") int teacherId, Model model) {
        int departmentId = teacherService.getTeacher(teacherId).getDepartment().getId();
        teacherService.deleteTeacher(teacherId);
        return "redirect:/getTeachersInDepartment/" + departmentId;
    }


}
