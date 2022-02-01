package com.karpusha.university.controller;

import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.exception.StudentIsNullException;
import com.karpusha.university.service.StudentGroupServiceRepositoryImpl;
import com.karpusha.university.service.StudentServiceRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentServiceRepositoryImpl studentService;

    @Autowired
    private StudentGroupServiceRepositoryImpl studentGroupService;

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
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult,
                              @PathVariable("studentGroupId")
                                      int studentGroupId, Model model) {
        if (bindingResult.hasErrors()) {
            LOG.info("saveStudent: Binding result has errors");
            StudentGroup studentGroup = studentGroupService.getStudentGroup(studentGroupId);
            model.addAttribute("studentGroup", studentGroup);
            model.addAttribute("student", student);
            return "add-student";
        } else {
            if (student == null) {
                LOG.error("Student is not found");
                throw new StudentIsNullException("Student error", "Student not found");
            }
            studentService.saveStudent(student, studentGroupId);
            return "redirect:/editStudentGroup/" + studentGroupId;
        }
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
        if (student == null) {
            LOG.error("Student not found in database");
            throw new StudentIsNullException("Student error", "Student not found");
        }
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
