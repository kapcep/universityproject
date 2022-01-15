package com.karpusha.university.controller;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.service.DepartmentService;
import com.karpusha.university.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/getAllDepartments")
    public String showAllDepartments(Model model) {
        List<Department> allDepartments = departmentService.getAllDepartment();
        model.addAttribute("allDepartments", allDepartments);
        return "all-departments";
    }

    @GetMapping("/addDepartment/{id}")
    public String addNewDepartment(@PathVariable("id")
                                           int facultyId, Model model) {
        Department department = new Department();
        Faculty faculty = facultyService.getFaculty(facultyId);
        model.addAttribute("department", department);
        model.addAttribute("faculty", faculty);
        return "add-department";
    }

    @GetMapping("/saveDepartment/{facultyId}")
    public String saveDepartment(@ModelAttribute("department") Department department,
                                 @PathVariable("facultyId")
                                         int facultyId, Model model) {
        departmentService.saveDepartment(facultyId, department);
        return "redirect:/editFaculty/" + facultyId;
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
        return "redirect:/getDepartmentsInFaculty/" + facultyId;
    }

    @GetMapping("/deleteDepartment/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") int departmentId, Model model) {
        int facultyId = departmentService.deleteDepartment(departmentId);
        return "redirect:/getDepartmentsInFaculty/" + facultyId;
    }

    @GetMapping("/getTeachersInDepartment/{departmentId}")
    public String getTeachersInDepartment(@PathVariable("departmentId") int departmentId, Model model) {
        List<Teacher> allTeachers = departmentService.getTeachersOfDepartment(departmentId);
        model.addAttribute("allTeachers", allTeachers);
        return "all-teachers";
    }
}
