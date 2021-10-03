package com.karpusha.university.service;

import com.karpusha.university.dao.StudentGroupDao;
import com.karpusha.university.entity.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService{

    @Autowired
    StudentGroupDao studentGroupDao;

    @Transactional
    @Override
    public List<StudentGroup> getAllStudentGroups() {
        return studentGroupDao.getAllStudentGroups();
    }

    @Override
    public void saveStudentGroup(StudentGroup studentGroup) {

    }

    @Override
    public StudentGroup getStudentGroup(int id) {
        return null;
    }

    @Override
    public void deleteStudentGroup(int id) {

    }
}
