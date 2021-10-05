package com.karpusha.university.controller;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.service.FacultyService;
import com.karpusha.university.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentGroupController {

    @Autowired
    StudentGroupService studentGroupService;
    @Autowired
    FacultyService facultyService;

    //get all student group
    @RequestMapping("/getAllStudentGroups")
    public String showAllStudentGroups(Model model) {
        List<StudentGroup> allStudentGroups = studentGroupService.getAllStudentGroups();
        model.addAttribute("allStudentGroups", allStudentGroups);
        return "all-student-groups";
    }

    //save student group
    @RequestMapping("/addNewStudentGroup/{id}")
    public String addNewStudetnGroup(@PathVariable("id")
                                             int facultyId, Model model) {
        StudentGroup studentGroup = new StudentGroup();
        Faculty faculty = facultyService.getFaculty(facultyId);
        model.addAttribute("studentGroup", studentGroup);
        model.addAttribute("faculty", faculty);
        return "add-student-group";
    }

    @RequestMapping("/saveStudentGroup/{facultyId}")
    public String saveStudentGroup(@ModelAttribute("studentGroup") StudentGroup studentGroup,
                                   @PathVariable("facultyId")
                                           int facultyId, Model model) {
        studentGroupService.saveStudentGroup(facultyId, studentGroup);
        return "redirect:/editFaculty/" + facultyId;
    }

    // edit student group
    @GetMapping("/editStudentGroup/{studentGroupId}")
    public String showStudentGroupUpdateForm(@PathVariable("studentGroupId")
                                                     int studentGroupId, Model model) {
        StudentGroup studentGroup = studentGroupService.getStudentGroup(studentGroupId);
        String studentGroupName = studentGroup.getGroupName();
        model.addAttribute("studentGroupId", studentGroupId);
        model.addAttribute("studentGroupName", studentGroupName);

        return "update-student-group";
    }

    @PostMapping("/updateStudentGroup/{studentGroupId}")
    public String updateStudentGroup(@PathVariable("studentGroupId") int studentGroupId,
                                     @ModelAttribute("studentGroupName") String studentGroupName, Model model) {
        studentGroupService.updateStudentGroupName(studentGroupId, studentGroupName);
        return "redirect:/getAllStudentGroups";
    }

    @GetMapping("/deleteStudentGroup/{studentGroupId}")
    public String deleteFaculty(@PathVariable("studentGroupId") int studentGroupId, Model model) {
        studentGroupService.deleteStudentGroup(studentGroupId);
        return "redirect:/getAllStudentGroups";
    }

}
