package com.karpusha.university.controller;

import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.service.StudentGroupService;
import com.karpusha.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentGroupService studentGroupService;

    @GetMapping("/getAllStudents")
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
        int studentGroupId = student.getStudentGroup().getId();
        model.addAttribute("student", student);
        model.addAttribute("studentGroupId", studentGroupId);

        return "update-student";
    }

    @PostMapping("/updateStudent/{studentGroupId}/{studentId}")
    public String updateStudent(@PathVariable("studentGroupId") int studentGroupId,
                                @PathVariable("studentId") int studentId,
                                @ModelAttribute("student") Student student, Model model) {
        student.setId(studentId);
        studentService.saveStudent(student, studentGroupId);
        model.addAttribute("student", student);
        return "redirect:/editStudent/" + studentId;
    }

    @GetMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId, Model model) {
        int studentGroupId = studentService.deleteStudent(studentId);
        return "redirect:/getStudentsInStudentGroup/" + studentGroupId;
    }

}
