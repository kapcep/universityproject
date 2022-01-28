package com.karpusha.university.service;

import com.karpusha.university.dao.StudentGroupRepository;
import com.karpusha.university.dao.StudentRepository;
import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceRepositoryImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentGroupRepository studentGroupRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student, int studentGroupId) {
        StudentGroup studentGroup = studentGroupRepository.getById(studentGroupId);
        student.setStudentGroup(studentGroup);
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(int studentId) {
        return studentRepository.getById(studentId);
    }

    @Override
    public int deleteStudent(int studentId) {
        Student student = getStudent(studentId);
        int studentGroupId = student.getStudentGroup().getId();
        studentRepository.delete(student);
        return studentGroupId;
    }
}
