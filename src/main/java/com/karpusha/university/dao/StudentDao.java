package com.karpusha.university.dao;

import com.karpusha.university.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getAllStudents();

    public void saveStudent(int studentId, Student student);

    public Student getStudent(int studentId);

    public void deleteStudent(int studentId);
}
