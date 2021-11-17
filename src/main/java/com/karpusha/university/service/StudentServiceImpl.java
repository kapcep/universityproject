package com.karpusha.university.service;

import com.karpusha.university.dao.StudentDao;
import com.karpusha.university.entity.Student;
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
        return studentDao.getStudent(studentId);
    }

    @Transactional
    @Override
    public void deleteStudent(int studentId) {
        studentDao.deleteStudent(studentId);
    }
}
