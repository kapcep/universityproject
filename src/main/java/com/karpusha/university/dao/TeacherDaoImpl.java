package com.karpusha.university.dao;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> getAllTeachers() {
        Session session = sessionFactory.getCurrentSession();
        List<Teacher> allTeachers = session.createQuery("from Teacher", Teacher.class).getResultList();
        return allTeachers;
    }

    @Override
    public void saveTeacher(Teacher teacher, int departmentId) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, departmentId);
        teacher.setDepartment(department);
        session.saveOrUpdate(teacher);
    }

    @Override
    public Teacher getTeacher(int teacherId) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.get(Teacher.class, teacherId);
        return teacher;
    }

    @Override
    public void deleteTeacher(int teacherId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Teacher> query = session.createQuery("delete from  Teacher where id =:teacherId");
        query.setParameter("teacherId", teacherId);
        query.executeUpdate();
    }
}
