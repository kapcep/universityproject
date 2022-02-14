package com.karpusha.university.dao;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Department> getAllDepartments() {
        List<Department> allDepartments = entityManager.createQuery("from Department").getResultList();
        return allDepartments;
    }

    @Override
    public void saveDepartment(int facultyId, Department department) {
        Faculty faculty = entityManager.find(Faculty.class, facultyId);
        if (department != null) {
            department.setFaculty(faculty);
            entityManager.persist(department);
        }
    }

    @Override
    public Department getDepartment(int departmentId) {
        Department department = entityManager.find(Department.class, departmentId);
        return department;
    }

    @Override
    public void deleteDepartment(int departmentId) {
        Department department = entityManager.find(Department.class, departmentId);
        if (department != null) {
            entityManager.remove(department);
        }
    }

    @Override
    public void updateDepartmentName(int departmentId, String departmentName) {
        Department department = getDepartment(departmentId);
        department.setName(departmentName);
        entityManager.merge(department);
    }
}
