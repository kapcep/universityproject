package com.karpusha.university.service;

import com.karpusha.university.dao.DepartmentDao;
import com.karpusha.university.entity.Department;
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
        return departmentDao.getDepartment(departmentId);
    }

    @Transactional
    @Override
    public void deleteDepartment(int departmentId) {
        departmentDao.deleteDepartment(departmentId);
    }

    @Transactional
    @Override
    public void updateDepartmentName(int departmentId, String departmentName) {
        departmentDao.updateDepartmentName(departmentId, departmentName);
    }
}
