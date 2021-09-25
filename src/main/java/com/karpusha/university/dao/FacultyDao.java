package com.karpusha.university.dao;

import com.karpusha.university.entity.Faculty;

import java.util.List;

public interface FacultyDao {

    public List<Faculty> getAllFaculties();

    public void saveFaculty(Faculty faculty);

    public Faculty getFaculty(int id);

    public void deleteFaculty(int id);
}
