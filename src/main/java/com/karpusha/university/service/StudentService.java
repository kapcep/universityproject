package com.karpusha.university.service;

import com.karpusha.university.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public void saveStudent(Student student);

    public Student getStudent(int studentId);

    public void deleteStudent(int studentId);
}
