package com.karpusha.university.controller;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.service.DepartmentService;
import com.karpusha.university.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    FacultyService facultyService;

    @RequestMapping("/getAllDepartments")
    public String showAllDepartments(Model model) {
        List<Department> allDepartments = departmentService.getAllDepartment();
        model.addAttribute("allDepartments", allDepartments);
        return "all-departments";
    }

    @RequestMapping("/addDepartment/{id}")
    public String addNewDepartment(@PathVariable("id")
                                           int facultyId, Model model) {
        Department department = new Department();
        Faculty faculty = facultyService.getFaculty(facultyId);
        model.addAttribute("department", department);
        model.addAttribute("faculty", faculty);
        return "add-department";
    }

    @RequestMapping("/saveDepartment/{facultyId}")
    public String saveDepartment(@ModelAttribute("department") Department department,
                                 @PathVariable("facultyId")
                                         int facultyId, Model model) {
        departmentService.saveDepartment(facultyId, department);
        return "redirect:/editDepartment/" + facultyId;
    }

    @GetMapping("/editDepartment/{departmentId}")
    public String showDepartmentUpdateForm(@PathVariable("departmentId")
                                                   int departmentId, Model model) {
        Department department = departmentService.getDepartment(departmentId);
        String departmentName = department.getName();
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("departmentName", departmentName);

        return "update-department";
    }

    @PostMapping("/updateDepartment/{departmentId}")
    public String updateDepartment(@PathVariable("departmentId") int departmentId,
                                   @ModelAttribute("departmentName") String departmentName, Model model) {
        int facultyId = departmentService.getDepartment(departmentId).getFaculty().getId();
        departmentService.updateDepartmentName(departmentId, departmentName);
        return "redirect:/getDepartmentInFaculty/" + facultyId;
    }

    @GetMapping("/deleteDepartment/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") int departmentId, Model model) {
        int facultyId = departmentService.getDepartment(departmentId).getFaculty().getId();
        departmentService.deleteDepartment(departmentId);
        return "redirect:/getDepartmentsInFaculty/" + facultyId;
    }

}
