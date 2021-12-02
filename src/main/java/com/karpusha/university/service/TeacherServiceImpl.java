package com.karpusha.university.service;

import com.karpusha.university.dao.TeacherDao;
import com.karpusha.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherDao teacherDao;

    @Transactional
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @Transactional
    @Override
    public void saveTeacher(Teacher teacher, int departmentId) {
        teacherDao.saveTeacher(teacher, departmentId);
    }

    @Transactional
    @Override
    public Teacher getTeacher(int teacherId) {
        return teacherDao.getTeacher(teacherId);
    }

    @Transactional
    @Override
    public void deleteTeacher(int teacherId) {
        teacherDao.deleteTeacher(teacherId);
    }
}
