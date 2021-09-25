package com.karpusha.university.service;

import com.karpusha.university.entity.Faculty;

import java.util.List;

public interface FacultyService {
    public List<Faculty> getAllFaculties();
    public void saveFaculty(Faculty faculty);
    public Faculty getFaculty(int id);
    public void deleteFaculty(int id);
}
