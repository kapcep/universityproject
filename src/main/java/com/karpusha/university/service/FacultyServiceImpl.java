package com.karpusha.university.service;

import com.karpusha.university.dao.FacultyDao;
import com.karpusha.university.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDao facultyDao;

    @Transactional
    @Override
    public List<Faculty> getAllFaculties() {
        return facultyDao.getAllFaculties();
    }

    @Transactional
    @Override
    public void saveFaculty(Faculty faculty) {
        facultyDao.saveFaculty(faculty);
    }

    @Transactional
    @Override
    public Faculty getFaculty(int id) {
        return facultyDao.getFaculty(id);
    }

    @Transactional
    @Override
    public void deleteFaculty(int id) {
        facultyDao.deleteFaculty(id);
    }
}
