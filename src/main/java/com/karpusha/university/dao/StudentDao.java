package com.karpusha.university.dao;

import com.karpusha.university.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getAllStudents();

    public void saveStudent(Student student, int studentGroupId);

    public Student getStudent(int studentId);

    public void deleteStudent(int studentId);
}
