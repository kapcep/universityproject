package com.karpusha.university.dao;

import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        List<Student> allStudents = entityManager.createQuery("from Student").getResultList();
        return allStudents;
    }

    @Override
    public void saveStudent(Student student, int studentGroupId) {
        StudentGroup studentGroup = entityManager.find(StudentGroup.class, studentGroupId);
        if (student != null) {
            student.setStudentGroup(studentGroup);
            entityManager.persist(student);
        }
    }

    @Override
    public Student getStudent(int studentId) {
        Student student = entityManager.find(Student.class, studentId);
        return student;
    }

    @Override
    public void deleteStudent(int studentId) {
        Student student = getStudent(studentId);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
