package com.karpusha.university.service;

import com.karpusha.university.controller.DepartmentController;
import com.karpusha.university.dao.DepartmentDao;
import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.exception.FacultyIsNullException;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    private static final Logger LOG = LoggerFactory.getLogger(DepartmentService.class);

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartments();
    }

    @Transactional
    @Override
    public void saveDepartment(int facultyId, Department department) {
        departmentDao.saveDepartment(facultyId, department);
    }

    @Override
    public Department getDepartment(int departmentId) {
        Department department = departmentDao.getDepartment(departmentId);
        if (department != null) {
            Hibernate.initialize(department.getTeachers());
        }
        return department;
    }

    @Transactional
    @Override
    public int deleteDepartment(int departmentId) {
        Department department = getDepartment(departmentId);
        int facultyId = department.getFaculty().getId();
        departmentDao.deleteDepartment(departmentId);
        return facultyId;
    }

    @Transactional
    @Override
    public void updateDepartmentName(int departmentId, String departmentName) {
        departmentDao.updateDepartmentName(departmentId, departmentName);
    }

    @Override
    public List<Teacher> getTeachersOfDepartment(int departmentId) {
        Department department = getDepartment(departmentId);
        if (department == null) {
            LOG.error("Department not found in database");
            throw new FacultyIsNullException("Department error", "Department is not found in database");
        }
        return department.getTeachers();
    }
}
