package com.karpusha.university.service;

import com.karpusha.university.dao.DepartmentRepository;
import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceRepositoryImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    private FacultyServiceRepositoryImpl facultyServiceRepositoryImpl;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(int facultyId, Department department) {
        Faculty faculty = facultyServiceRepositoryImpl.getFaculty(facultyId);
        department.setFaculty(faculty);
        departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(int departmentId) {
        Department department = null;
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        if (optionalDepartment.isPresent()) {
            department = optionalDepartment.get();
        }
        return department;
    }

    @Override
    public int deleteDepartment(int departmentId) {
        Department department = getDepartment(departmentId);
        int faucultyId = department.getFaculty().getId();
        departmentRepository.delete(department);
        return faucultyId;
    }

    @Override
    public void updateDepartmentName(int departmentId, String departmentName) {
        Department department = getDepartment(departmentId);
        department.setName(departmentName);
        departmentRepository.save(department);
    }

    @Override
    public List<Teacher> getTeachersOfDepartment(int departmentId) {
        Department department = getDepartment(departmentId);
        return department.getTeachers();
    }
}
