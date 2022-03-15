package com.karpusha.university.controller;

import com.karpusha.university.entity.Student;
import com.karpusha.university.service.StudentServiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    private StudentServiceRepositoryImpl studentService;


    @GetMapping("")
    public List<Student> showAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        Student student = studentService.getStudent(studentId);
        return student;
    }

    @PostMapping("/{studentGroupId}")
    public Student saveStudent(@PathVariable("studentGroupId")
                                       int studentGroupId,
                               @RequestBody Student student) {
        studentService.saveStudent(student, studentGroupId);
        return student;
    }

    @PutMapping("/{studentGroupId}")
    public Student updateStudent(@PathVariable("studentGroupId") int studentGroupId,
                                 @RequestBody Student student) {
        studentService.saveStudent(student, studentGroupId);
        return student;
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.deleteStudent(studentId);
        return "Student with id = " + studentId + " was deleted";
    }
}


