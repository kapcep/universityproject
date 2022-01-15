package com.karpusha.university.service;

import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;

import java.util.List;

public interface StudentGroupService {
    public List<StudentGroup> getAllStudentGroups();

    public void saveStudentGroup(int facultyId, StudentGroup studentGroup);

    public StudentGroup getStudentGroup(int id);

    public int deleteStudentGroup(int id);

    public void updateStudentGroupName(int studentGroupId, String studentGroupName);

    public List<Student> getStudentsOfStudentGroup(int studentGroupId);
}
