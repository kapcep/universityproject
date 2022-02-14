package com.karpusha.university.dao;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentGroupDaoImpl implements StudentGroupDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<StudentGroup> getAllStudentGroups() {
        List<StudentGroup> allStudentGroups = entityManager.createQuery("from StudentGroup").getResultList();
        return allStudentGroups;
    }

    @Override
    public void saveStudentGroup(int facultyId, StudentGroup studentGroup) {
        Faculty faculty = entityManager.find(Faculty.class, facultyId);
        if (studentGroup != null) {
            studentGroup.setFaculty(faculty);
            entityManager.persist(studentGroup);
        }
    }

    @Override
    public StudentGroup getStudentGroup(int id) {
        StudentGroup studentGroup = entityManager.find(StudentGroup.class, id);
        return studentGroup;
    }

    @Override
    public void deleteStudentGroup(int id) {
        StudentGroup studentGroup = entityManager.find(StudentGroup.class, id);
        if (studentGroup != null) {
            entityManager.remove(studentGroup);
        }
    }

    @Override
    public void updateStudentGroupName(int studentGroupId, String studentGroupName) {
        StudentGroup studentGroup = getStudentGroup(studentGroupId);
        studentGroup.setGroupName(studentGroupName);
        entityManager.merge(studentGroup);
    }
}
