package com.karpusha.university.controller;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.exception.FacultyIsNullException;
import com.karpusha.university.service.FacultyServiceRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class FacultyController {

    private static final Logger LOG = LoggerFactory.getLogger(FacultyController.class);

    @Autowired
    private FacultyServiceRepositoryImpl facultyServiceRepository;


    @GetMapping("/")
    public String showAllFaculties(Model model) {
        List<Faculty> allFaculties = facultyServiceRepository.getAllFaculties();
        model.addAttribute("allFaculties", allFaculties);
        return "index";
    }

    @GetMapping("/addNewFaculty")
    public String addNewFaculty(Model model) {
        Faculty faculty = new Faculty();
        model.addAttribute("faculty", faculty);
        return "add-faculty";
    }

    @PostMapping("/saveFaculty")
    public String saveFaculty(@ModelAttribute("faculty") Faculty faculty) {
        facultyServiceRepository.saveFaculty(faculty);
        return "redirect:/";
    }

    @GetMapping("/editFaculty/{id}")
    public String showFacultyUpdateForm(@PathVariable("id")
                                                int id, Model model) {
        Faculty faculty = facultyServiceRepository.getFaculty(id);
        if (faculty == null) {
            LOG.error("Faculty not found in database");
            throw new FacultyIsNullException("Faculty error", "Faculty is not found in database");
        }
        model.addAttribute("faculty", faculty);
        return "update-faculty";
    }

    @PostMapping("/updateFaculty/{id}")
    public String updateFaculty(@PathVariable("id") int id, @ModelAttribute("faculty") Faculty faculty, Model model) {
        faculty.setId(id);
        facultyServiceRepository.saveFaculty(faculty);
        model.addAttribute("faculty", faculty);
        return "redirect:/editFaculty/" + id;
    }

    @GetMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable("id") int id, Model model) {
        facultyServiceRepository.deleteFaculty(id);
        return "redirect:/";
    }

    @GetMapping("/getStudentGroupsInFaculty/{id}")
    public String getStudentGroupsInFaculty(@PathVariable("id") int id, Model model) {
        Faculty faculty = facultyServiceRepository.getFaculty(id);
        List<StudentGroup> studentGroups = faculty.getStudentGroups();
        model.addAttribute("allStudentGroups", studentGroups);

        return "all-student-groups";
    }

    @GetMapping("/getDepartmentsInFaculty/{id}")
    public String getDepartmentsInFaculty(@PathVariable("id") int id, Model model) {
        Faculty faculty = facultyServiceRepository.getFaculty(id);
        if (faculty == null) {
            LOG.error("Faculty not found in database");
            throw new FacultyIsNullException("Faculty error", "Faculty is not found in database");
        }
        List<Department> departments = faculty.getDepartments();
        model.addAttribute("allDepartments", departments);

        return "all-departments";
    }
}
