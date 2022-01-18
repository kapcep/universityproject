package com.karpusha.university.controller;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.service.FacultyService;
import com.karpusha.university.service.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentGroupController {

    @Autowired
    StudentGroupService studentGroupService;
    @Autowired
    FacultyService facultyService;

    //get all student group
    @GetMapping("/getAllStudentGroups")
    public String showAllStudentGroups(Model model) {
        List<StudentGroup> allStudentGroups = studentGroupService.getAllStudentGroups();
        model.addAttribute("allStudentGroups", allStudentGroups);
        return "all-student-groups";
    }

    //save student group
    @GetMapping("/addNewStudentGroup/{id}")
    public String addNewStudentsGroup(@PathVariable("id")
                                              int facultyId, Model model) {
        StudentGroup studentGroup = new StudentGroup();
        Faculty faculty = facultyService.getFaculty(facultyId);
        model.addAttribute("studentGroup", studentGroup);
        model.addAttribute("faculty", faculty);
        return "add-student-group";
    }

    @PostMapping("/saveStudentGroup/{facultyId}")
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
        int facultyId = studentGroupService.getStudentGroup(studentGroupId).getFaculty().getId();
        studentGroupService.updateStudentGroupName(studentGroupId, studentGroupName);
        return "redirect:/getStudentGroupsInFaculty/" + facultyId;
    }

    @GetMapping("/deleteStudentGroup/{studentGroupId}")
    public String deleteStudentGroup(@PathVariable("studentGroupId") int studentGroupId, Model model) {
        int facultyId = studentGroupService.deleteStudentGroup(studentGroupId);
        return "redirect:/getStudentGroupsInFaculty/" + facultyId;
    }

    @GetMapping("/getStudentsInStudentGroup/{studentGroupId}")
    public String getStudentsInStudentGroup(@PathVariable("studentGroupId") int studentGroupId, Model model) {
        List<Student> allStudents = studentGroupService.getStudentsOfStudentGroup(studentGroupId);
        model.addAttribute("allStudents", allStudents);
        return "all-students";
    }

}
