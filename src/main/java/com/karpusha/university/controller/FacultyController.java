package com.karpusha.university.controller;

import com.karpusha.university.dao.FacultyDao;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping("/")
    public String showAllFaculties(Model model) {
//        List<Faculty> allFaculties = facultyService.getAllFaculties();
        List<Faculty> allFaculties = new ArrayList<>();
        allFaculties.add(new Faculty("IT"));
        allFaculties.add(new Faculty("HR"));
        allFaculties.add(new Faculty("QA"));
        model.addAttribute("allFaculties", allFaculties);

        return "index";
    }

}
