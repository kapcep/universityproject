package com.karpusha.university.controller;

import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.service.StudentGroupServiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentGroupRestController {

    @Autowired
    StudentGroupServiceRepositoryImpl studentGroupService;

    @GetMapping("/studentGroups")
    public List<StudentGroup> getAllStudentGroups(Model model) {
        List<StudentGroup> allStudentGroups = studentGroupService.getAllStudentGroups();
        return allStudentGroups;
    }

    @PostMapping("/studentGroups/{facultyId}")
    public StudentGroup saveStudentGroup(@PathVariable("facultyId") int facultyId,
                                         @RequestBody StudentGroup studentGroup) {
        studentGroupService.saveStudentGroup(facultyId, studentGroup);
        return studentGroup;
    }

    @PutMapping("/studentGroups/{facultyId}")
    public StudentGroup udpateStudentGroup(@PathVariable("facultyId") int facultyId,
                                           @RequestBody StudentGroup studentGroup) {
        studentGroupService.saveStudentGroup(facultyId, studentGroup);
        return studentGroup;
    }

    @DeleteMapping("/studentGroups/{groupId}")
    public String deleteFaculty(@PathVariable("groupId") int studentGroupId) {
        studentGroupService.deleteStudentGroup(studentGroupId);
        return "StudentGroup with id = " + studentGroupId + " was deleted";
    }

    @GetMapping("/studentGroups/{studentGroupId}")
    public List<Student> getStudentsInStudentGroup(@PathVariable("studentGroupId") int studentGroupId) {
        List<Student> allStudents = studentGroupService.getStudentsOfStudentGroup(studentGroupId);
        return allStudents;
    }
}
