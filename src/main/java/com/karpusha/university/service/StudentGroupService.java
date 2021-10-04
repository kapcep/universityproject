package com.karpusha.university.service;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.StudentGroup;

import java.util.List;

public interface StudentGroupService {
    public List<StudentGroup> getAllStudentGroups();
    public void saveStudentGroup(Faculty faculty, StudentGroup studentGroup);
    public StudentGroup getStudentGroup(int id);
    public void deleteStudentGroup(int id);
}
