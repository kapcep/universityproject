package com.karpusha.university.dao;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
        Session session = entityManager.unwrap(Session.class);
        List<Department> allDepartments = session.createQuery("from Department ", Department.class).getResultList();
        return allDepartments;
    }

    @Override
    public void saveDepartment(int facultyId, Department department) {
        Session session = entityManager.unwrap(Session.class);
        Faculty faculty = session.get(Faculty.class, facultyId);
        department.setFaculty(faculty);
        session.saveOrUpdate(department);
    }

    @Override
    public Department getDepartment(int departmentId) {
        Session session = entityManager.unwrap(Session.class);
        Department department = session.get(Department.class, departmentId);
        return department;
    }

    @Override
    public void deleteDepartment(int departmentId) {
        Session session = entityManager.unwrap(Session.class);
        Query<Department> query = session.createQuery("delete from  Department where id =:departmentId");
        query.setParameter("departmentId", departmentId);
        query.executeUpdate();
    }

    @Override
    public void updateDepartmentName(int departmentId, String departmentName) {
        Session session = entityManager.unwrap(Session.class);
        Department department = session.get(Department.class, departmentId);
        department.setName(departmentName);
        session.saveOrUpdate(department);
    }
}
