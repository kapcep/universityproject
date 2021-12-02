package com.karpusha.university.dao;

import com.karpusha.university.entity.Teacher;

import java.util.List;

public interface TeacherDao {
    public List<Teacher> getAllTeachers();

    public void saveTeacher(Teacher teacher, int departmentId);

    public Teacher getTeacher(int teacherId);

    public void deleteTeacher(int teacherId);
}
