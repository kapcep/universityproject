package com.karpusha.university.service;

import com.karpusha.university.dao.FacultyRepository;
import com.karpusha.university.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceRepositoryImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFaculty(int id) {
        Faculty faculty = null;
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()) {
            faculty = optionalFaculty.get();
        }
        return faculty;
    }

    @Override
    public void deleteFaculty(int id) {
        facultyRepository.deleteById(id);
    }
}
