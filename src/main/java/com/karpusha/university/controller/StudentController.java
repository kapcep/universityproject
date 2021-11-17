package com.karpusha.university.controller;

import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.service.StudentGroupService;
import com.karpusha.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentGroupService studentGroupService;

    @RequestMapping("/getAllStudents")
    public String showAllStudents(Model model) {
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("allStudents", allStudents);
        return "all-students";
    }

    @RequestMapping("/addNewStudent/{id}")
    public String addNewStudent(@PathVariable("id")
                                        int studentGroupId, Model model) {

        Student student = new Student();
        StudentGroup studentGroup = studentGroupService.getStudentGroup(studentGroupId);
        model.addAttribute("studentGroup", studentGroup);
        model.addAttribute("student", student);
        return "add-student";
    }

    @RequestMapping("/saveStudent/{studentGroupId}")
    public String saveStudent(@ModelAttribute("student") Student student,
                              @PathVariable("studentGroupId")
                                      int studentGroupId, Model model) {
        studentService.saveStudent(student, studentGroupId);
        return "redirect:/editStudentGroup/" + studentGroupId;
    }

    @GetMapping("/editStudent/{studentId}")
    public String showStudentUpdateForm(@PathVariable("studentId")
                                                int studentId, Model model) {
        Student student = studentService.getStudent(studentId);
        String studentStudentName = student.getStudentName();
        String studentSurName = student.getStudentSurName();
        int studentAge = student.getAge();

        model.addAttribute("studentId", studentId);
        model.addAttribute("studentStudentName", studentStudentName);
        model.addAttribute("studentSurName", studentSurName);
        model.addAttribute("studentAge", studentAge);
        return "update-student";
    }

}
