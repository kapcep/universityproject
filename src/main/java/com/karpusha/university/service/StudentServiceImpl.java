package com.karpusha.university.service;

import com.karpusha.university.dao.StudentDao;
import com.karpusha.university.entity.Student;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Transactional
    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Transactional
    @Override
    public void saveStudent(Student student, int studentGroupId) {
        studentDao.saveStudent(student, studentGroupId);
    }

    @Transactional
    @Override
    public Student getStudent(int studentId) {
        Student student = studentDao.getStudent(studentId);
        Hibernate.initialize(student.getStudentGroup());
        return student;

    }

    @Transactional
    @Override
    public int deleteStudent(int studentId) {
        Student student = getStudent(studentId);
        int studentGroupId = student.getStudentGroup().getId();
        studentDao.deleteStudent(studentId);
        return studentGroupId;
    }
}
