package com.karpusha.university.dao;

import com.karpusha.university.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FacultyDaoImpl implements FacultyDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Faculty> getAllFaculties() {
        List<Faculty> allFaculties = entityManager.createQuery("from Faculty").getResultList();

        return allFaculties;
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        entityManager.persist(faculty);
    }

    @Override
    public Faculty getFaculty(int id) {
        Faculty faculty = entityManager.find(Faculty.class, id);
        if (faculty != null) {
            faculty.getStudentGroups();
        }
        return faculty;
    }

    @Override
    public void deleteFaculty(int id) {
        Faculty faculty = entityManager.find(Faculty.class, id);
        if (faculty != null) {
            entityManager.remove(faculty);
        }
    }
}
