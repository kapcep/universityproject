package com.karpusha.university.service;

import com.karpusha.university.entity.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartment();

    public void saveDepartment(int facultyId, Department department);

    public Department getDepartment(int departmentId);

    public void deleteDepartment(int departmentId);

    public void updateDepartmentName(int departmentId, String departmentName);
}
