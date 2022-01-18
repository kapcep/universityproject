package com.karpusha.university.service;

import com.karpusha.university.dao.TeacherDao;
import com.karpusha.university.entity.Teacher;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Transactional
    @Override
    public void saveTeacher(Teacher teacher, int departmentId) {
        teacherDao.saveTeacher(teacher, departmentId);
    }

    @Override
    public Teacher getTeacher(int teacherId) {
        Teacher teacher = teacherDao.getTeacher(teacherId);
        Hibernate.initialize(teacher.getDepartment());
        return teacher;
    }

    @Transactional
    @Override
    public int deleteTeacher(int teacherId) {
        Teacher teacher = getTeacher(teacherId);
        int departmentId = teacher.getDepartment().getId();
        teacherDao.deleteTeacher(teacherId);
        return departmentId;
    }
}
