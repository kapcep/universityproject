package com.karpusha.university.controller;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.service.FacultyServiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacultyRestController {

    @Autowired
    FacultyServiceRepositoryImpl facultyService;

    @GetMapping("/faculties")
    public List<Faculty> showAllFaculties() {
        List<Faculty> allFaculties = facultyService.getAllFaculties();
        return allFaculties;
    }
}
