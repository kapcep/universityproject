package com.karpusha.university.controller;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.exception.FacultyIsNullException;
import com.karpusha.university.service.FacultyServiceRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculties")
public class FacultyRestController {

    @Autowired
    FacultyServiceRepositoryImpl facultyService;

    @GetMapping("")
    public List<Faculty> showAllFaculties() {
        List<Faculty> allFaculties = facultyService.getAllFaculties();
        return allFaculties;
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable int id) {
        Faculty faculty = facultyService.getFaculty(id);
        if (faculty == null) {
            throw new FacultyIsNullException("FacultyIsNull", "There is no faculty with id = " + id + " in database");
        }
        return faculty;
    }

    @PostMapping("")
    public Faculty saveFaculty(@RequestBody Faculty faculty) {
        facultyService.saveFaculty(faculty);
        return faculty;
    }

    @PutMapping("")
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        facultyService.saveFaculty(faculty);
        return faculty;
    }

    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable("id") int id) {
        Faculty faculty = facultyService.getFaculty(id);
        if (faculty == null) {
            throw new FacultyIsNullException("FacultyIsNull", "There is no faculty with id = " + id + " in database");
        }
        facultyService.deleteFaculty(id);
        return "Faculty with id = " + id + " was deleted";
    }

    @GetMapping("/studentGroups/{id}")
    public List<StudentGroup> getStudentGroupsInFaculty(@PathVariable("id") int id) {
        Faculty faculty = facultyService.getFaculty(id);
        List<StudentGroup> studentGroups = faculty.getStudentGroups();
        return studentGroups;
    }

    @GetMapping("/departments/{id}")
    public List<Department> getDepartmentsInFaculty(@PathVariable("id") int id, Model model) {
        Faculty faculty = facultyService.getFaculty(id);
        List<Department> departments = faculty.getDepartments();
        return departments;
    }
}
