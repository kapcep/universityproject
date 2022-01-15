package com.karpusha.university.service;

import com.karpusha.university.dao.DepartmentDao;
import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Transactional
    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartments();
    }

    @Transactional
    @Override
    public void saveDepartment(int facultyId, Department department) {
        departmentDao.saveDepartment(facultyId, department);
    }

    @Transactional
    @Override
    public Department getDepartment(int departmentId) {
        Department department = departmentDao.getDepartment(departmentId);
        Hibernate.initialize(department.getTeachers());
        return department;
    }

    @Transactional
    @Override
    public int deleteDepartment(int departmentId) {
        Department department = getDepartment(departmentId);
        int facultyId = department.getFaculty().getId();
        departmentDao.deleteDepartment(departmentId);
        return  facultyId;
    }

    @Transactional
    @Override
    public void updateDepartmentName(int departmentId, String departmentName) {
        departmentDao.updateDepartmentName(departmentId, departmentName);
    }

    @Override
    public List<Teacher> getTeachersOfDepartment(int departmentId) {
        Department department = getDepartment(departmentId);
        return department.getTeachers();
    }
}
