package com.karpusha.university.controller;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.exception.FacultyIsNullException;
import com.karpusha.university.exception.StudentIsNullException;
import com.karpusha.university.service.FacultyServiceRepositoryImpl;
import com.karpusha.university.service.StudentGroupServiceRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentGroupController {

    private static final Logger LOG = LoggerFactory.getLogger(StudentGroupController.class);
    @Autowired
    StudentGroupServiceRepositoryImpl studentGroupService;
    @Autowired
    FacultyServiceRepositoryImpl facultyService;

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
        if (faculty == null) {
            LOG.error("Faculty is not found in database");
            throw new FacultyIsNullException("Faculty error", "Faculty is not found in database");
        }
        model.addAttribute("studentGroup", studentGroup);
        model.addAttribute("faculty", faculty);
        return "add-student-group";
    }

    @PostMapping("/saveStudentGroup/{facultyId}")
    public String saveStudentGroup(@Valid @ModelAttribute("studentGroup") StudentGroup studentGroup,
                                   BindingResult bindingResult,
                                   @PathVariable("facultyId")
                                           int facultyId, Model model) {
        if (bindingResult.hasErrors()) {
            Faculty faculty = facultyService.getFaculty(facultyId);
            model.addAttribute("studentGroup", studentGroup);
            model.addAttribute("faculty", faculty);
            return "add-student-group";
        } else {

            if (studentGroup == null) {
                LOG.error("StudentGroup is not found");
                throw new StudentIsNullException("StudentGroup error", "StudentGroup is not found");
            }
            studentGroupService.saveStudentGroup(facultyId, studentGroup);
            return "redirect:/editFaculty/" + facultyId;
        }
    }

    // edit student group
    @GetMapping("/editStudentGroup/{studentGroupId}")
    public String showStudentGroupUpdateForm(@PathVariable("studentGroupId")
                                                     int studentGroupId, Model model) {
        StudentGroup studentGroup = studentGroupService.getStudentGroup(studentGroupId);
        if (studentGroup == null) {
            LOG.error("StudentGroup is not found");
            throw new StudentIsNullException("StudentGroup error", "StudentGroup is not found");
        }
        model.addAttribute("studentGroupId", studentGroupId);
        model.addAttribute("studentGroup", studentGroup);

        return "update-student-group";
    }

    @PostMapping("/updateStudentGroup/{studentGroupId}")
    public String updateStudentGroup(@PathVariable("studentGroupId") int studentGroupId,
                                     @Valid @ModelAttribute("studentGroup") StudentGroup studentGroup,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("studentGroupId", studentGroupId);
            model.addAttribute("studentGroup", studentGroup);
            return "update-student-group";
        } else {
            int facultyId = studentGroupService.getStudentGroup(studentGroupId).getFaculty().getId();
            studentGroupService.updateStudentGroupName(studentGroupId, studentGroup.getGroupName());
            return "redirect:/getStudentGroupsInFaculty/" + facultyId;
        }
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
