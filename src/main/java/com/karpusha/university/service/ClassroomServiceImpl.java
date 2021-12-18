package com.karpusha.university.service;

import com.karpusha.university.dao.ClassroomDao;
import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.Department;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    ClassroomDao classroomDao;

    @Transactional
    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomDao.getAllClassrooms();
    }

    @Transactional
    @Override
    public void saveClassroom(int departmentId, Classroom classroom) {
        classroomDao.saveClassroom(departmentId, classroom);
    }

    @Transactional
    @Override
    public Classroom getClassroom(int classroomId) {
        Classroom classroom = classroomDao.getClassroom(classroomId);
        Hibernate.initialize(classroom.getDepartment());
        return classroom;
    }

    @Transactional
    @Override
    public void deleteClassroom(int classroomId) {
        classroomDao.deleteClassroom(classroomId);
    }

    @Transactional
    @Override
    public void updateClassroom(int classroomId, String classroomName, int classroomNumber, Department department) {
        classroomDao.updateClassroom(classroomId, classroomName, classroomNumber, department);
    }
}
