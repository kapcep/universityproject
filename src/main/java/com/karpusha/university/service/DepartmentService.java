package com.karpusha.university.service;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartment();

    public void saveDepartment(int facultyId, Department department);

    public Department getDepartment(int departmentId);

    public int deleteDepartment(int departmentId);

    public void updateDepartmentName(int departmentId, String departmentName);

    public  List<Teacher>  getTeachersOfDepartment(int departmentId);
}
