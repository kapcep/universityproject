package com.karpusha.university.service;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.StudentGroup;

import java.util.List;

public interface StudentGroupService {
    public List<StudentGroup> getAllStudentGroups();

    public void saveStudentGroup(int facultyId, StudentGroup studentGroup);

    public StudentGroup getStudentGroup(int id);

    public void deleteStudentGroup(int id);

    public void updateStudentGroupName(int studentGroupId, String studentGroupName);
}
