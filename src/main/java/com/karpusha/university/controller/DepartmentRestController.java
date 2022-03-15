package com.karpusha.university.controller;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.service.DepartmentServiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {

    @Autowired
    DepartmentServiceRepositoryImpl departmentService;

    @GetMapping("/departments")
    public List<Department> showAllDepartments() {
        List<Department> allDepartments = departmentService.getAllDepartment();
        return allDepartments;
    }

    @PostMapping("/departments/{facultyId}")
    public Department saveDepartment(@PathVariable("facultyId") int facultyId,
                                     @RequestBody Department department) {
        departmentService.saveDepartment(facultyId, department);
        return department;
    }

    @PutMapping("/departments/{facultyId}")
    public Department updateDepartment(@PathVariable("facultyId") int facultyId,
                                       @RequestBody Department department) {
        departmentService.saveDepartment(facultyId, department);
        return department;
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") int departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "Department with id = " + departmentId + " was deleted";
    }

    @GetMapping("/departments/{departmentId}")
    public List<Teacher> getTeachersInDepartment(@PathVariable("departmentId") int departmentId) {
        List<Teacher> allTeachers = departmentService.getTeachersOfDepartment(departmentId);
        return allTeachers;
    }


}
