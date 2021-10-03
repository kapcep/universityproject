package com.karpusha.university.dao;

import com.karpusha.university.entity.StudentGroup;

import java.util.List;

public interface StudentGroupDao {
    public List<StudentGroup> getAllStudentGroups();

    public void saveStudentGroup(StudentGroup studentGroup);

    public StudentGroup getStudentGroup(int id);

    public void deleteStudentGroup(int id);
}
