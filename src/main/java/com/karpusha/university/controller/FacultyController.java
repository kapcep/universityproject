package com.karpusha.university.controller;

import com.karpusha.university.dao.FacultyDao;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/")
    public String showAllFaculties(Model model) {
        List<Faculty> allFaculties = facultyService.getAllFaculties();
        model.addAttribute("allFaculties", allFaculties);

        return "index";
    }

    @RequestMapping("/addNewFaculty")
    public String addNewFaculty(Model model) {
        Faculty faculty = new Faculty();
        model.addAttribute("faculty", faculty);

        return "add-faculty";
    }

    @RequestMapping("/saveFaculty")
    public String saveFaculty(@ModelAttribute("faculty") Faculty faculty) {
        facultyService.saveFaculty(faculty);
        return "redirect:/";
    }

    @GetMapping("/editFaculty/{id}")
    public String showFacultyUpdateForm(@PathVariable("id")
                                                int id, Model model) {
        Faculty faculty = facultyService.getFaculty(id);
        model.addAttribute("faculty", faculty);
        return "update-faculty";
    }

    @PostMapping("/updateFaculty/{id}")
    public String updateFaculty(@PathVariable("id") int id, @ModelAttribute("faculty") Faculty faculty, Model model) {

        faculty.setId(id);
        facultyService.saveFaculty(faculty);
        model.addAttribute("faculty", faculty);
        return "redirect:/";
    }

    @GetMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable("id") int id, Model model) {
        facultyService.deleteFaculty(id);
        return "redirect:/";
    }

    @GetMapping("/getStudentGroupsInFaculty/{id}")
    public String getStudentGroupsInFaculty(@PathVariable("id") int id, Model model) {
        Faculty faculty = facultyService.getFaculty(id);
        System.out.println(faculty.getStudentGroups());

        return "all-students";
    }

}
