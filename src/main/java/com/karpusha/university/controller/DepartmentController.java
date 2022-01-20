package com.karpusha.university.controller;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.exception.DepartmentIsNullException;
import com.karpusha.university.exception.FacultyIsNullException;
import com.karpusha.university.service.DepartmentService;
import com.karpusha.university.service.FacultyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(DepartmentController.class);
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
        if (faculty == null) {
            LOG.error("Faculty is not found in database");
            throw new FacultyIsNullException("Faculty error", "Faculty is not found in database");
        }
        model.addAttribute("department", department);
        model.addAttribute("faculty", faculty);
        return "add-department";
    }

    @PostMapping("/saveDepartment/{facultyId}")
    public String saveDepartment(@ModelAttribute("department") Department department,
                                 @PathVariable("facultyId")
                                         int facultyId, Model model) {
        if (department == null) {
            LOG.error("Department i not found");
            throw new DepartmentIsNullException("Department error", "Department is not found");
        }
        departmentService.saveDepartment(facultyId, department);
        return "redirect:/editFaculty/" + facultyId;
    }

    @GetMapping("/editDepartment/{departmentId}")
    public String showDepartmentUpdateForm(@PathVariable("departmentId")
                                                   int departmentId, Model model) {
        Department department = departmentService.getDepartment(departmentId);
        if (department == null) {
            LOG.error("Department not found in database");
            throw new DepartmentIsNullException("Department error", "Department is not found");
        }
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
