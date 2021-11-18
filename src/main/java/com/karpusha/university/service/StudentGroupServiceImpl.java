package com.karpusha.university.service;

import com.karpusha.university.dao.StudentGroupDao;
import com.karpusha.university.entity.StudentGroup;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    @Autowired
    StudentGroupDao studentGroupDao;

    @Transactional
    @Override
    public List<StudentGroup> getAllStudentGroups() {
        return studentGroupDao.getAllStudentGroups();
    }

    @Transactional
    @Override
    public void saveStudentGroup(int facultyId, StudentGroup studentGroup) {
        studentGroupDao.saveStudentGroup(facultyId, studentGroup);
    }

    @Transactional
    @Override
    public StudentGroup getStudentGroup(int id) {
        StudentGroup studentGroup = studentGroupDao.getStudentGroup(id);
        Hibernate.initialize(studentGroup.getStudents());
        return studentGroup;
    }

    @Transactional
    @Override
    public void deleteStudentGroup(int id) {
        studentGroupDao.deleteStudentGroup(id);
    }

    @Transactional
    @Override
    public void updateStudentGroupName(int studentGroupId, String studentGroupName) {
        studentGroupDao.updateStudentGroupName(studentGroupId, studentGroupName);
    }
}
