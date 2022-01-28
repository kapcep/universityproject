package com.karpusha.university.service;

import com.karpusha.university.dao.DepartmentRepository;
import com.karpusha.university.dao.TeacherRepository;
import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceRepositoryImpl implements TeacherService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(Teacher teacher, int departmentId) {
        Department department = departmentRepository.getById(departmentId);
        teacher.setDepartment(department);
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacher(int teacherId) {
        return teacherRepository.getById(teacherId);
    }

    @Override
    public int deleteTeacher(int teacherId) {
        Teacher teacher = getTeacher(teacherId);
        int departmentId = teacher.getDepartment().getId();
        teacherRepository.delete(teacher);
        return departmentId;
    }
}
