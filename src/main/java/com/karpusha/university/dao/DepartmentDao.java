package com.karpusha.university.dao;

import com.karpusha.university.entity.Department;

import java.util.List;

public interface DepartmentDao {
    public List<Department> getAllDepartments();

    public void saveDepartment(int facultyId, Department department);

    public Department getDepartment(int departmentId);

    public void deleteDepartment(int departmentId);

    public void updateDepartmentName(int departmentId, String departmentName);
}
