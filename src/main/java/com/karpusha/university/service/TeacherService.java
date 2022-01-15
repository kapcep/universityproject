package com.karpusha.university.service;

import com.karpusha.university.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeachers();

    public void saveTeacher(Teacher teacher, int departmentId);

    public Teacher getTeacher(int teacherId);

    public int deleteTeacher(int teacherId);
}
