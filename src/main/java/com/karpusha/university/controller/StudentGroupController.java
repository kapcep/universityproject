package com.karpusha.university.controller;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.service.FacultyService;
import com.karpusha.university.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentGroupController {

    @Autowired
    StudentGroupService studentGroupService;
    @Autowired
    FacultyService facultyService;

    @RequestMapping("/getAllStudentGroups")
    public String showAllStudentGroups(Model model) {
        List<StudentGroup> allStudentGroups = studentGroupService.getAllStudentGroups();
        model.addAttribute("allStudentGroups", allStudentGroups);

        return "all-student-groups";
    }

    @RequestMapping("/addNewStudentGroup/{id}")
    public String addNewStudetnGroup(@PathVariable("id")
                                             int id, Model model) {
        StudentGroup studentGroup = new StudentGroup();
        Faculty faculty = facultyService.getFaculty(id);
        model.addAttribute("studentGroup", studentGroup);
        model.addAttribute("faculty", faculty);

        return "add-student-group";
    }

    @RequestMapping("/saveStudentGroup")
    public String saveStudentGroup(@ModelAttribute("studentGroup") StudentGroup studentGroup,
                                   @ModelAttribute("faculty") Faculty faculty) {
        System.out.println("Faculty in saveFaculty method is: " + faculty);
        System.out.println("SG in saveFaculty method is: " + studentGroup);
        studentGroupService.saveStudentGroup(faculty, studentGroup);
//        refactor: return to Faculty page not to list of Faculties
        return "redirect:/";
    }

}
