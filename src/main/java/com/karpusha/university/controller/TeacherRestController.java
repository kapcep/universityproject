package com.karpusha.university.controller;

import com.karpusha.university.entity.Teacher;
import com.karpusha.university.service.TeacherServiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherRestController {
    @Autowired
    private TeacherServiceRepositoryImpl teacherService;

    @GetMapping("/teachers")
    public List<Teacher> showAllTeachers() {
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    }

    @GetMapping("/teachers/{teacherId}")
    public Teacher getTeacher(@PathVariable("teacherId") int teacherId) {
        Teacher teacher = teacherService.getTeacher(teacherId);
        return teacher;
    }

    @PostMapping("/teachers/{departmentId}")
    public Teacher saveTeacher(@PathVariable("departmentId")
                                       int departmentId,
                               @RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher, departmentId);
        return teacher;
    }

    @PutMapping("/teachers/{departmentId}")
    public Teacher updateTeacher(@PathVariable("departmentId") int departmentId,
                                 @RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher, departmentId);
        return teacher;
    }

    @DeleteMapping("/teachers/{teacherId}")
    public String deleteTeacher(@PathVariable("teacherId") int teacherId) {
        teacherService.deleteTeacher(teacherId);
        return "Teacher with id = " + teacherId + " was deleted";
    }
}
