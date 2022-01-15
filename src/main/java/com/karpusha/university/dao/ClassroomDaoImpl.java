package com.karpusha.university.dao;

import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassroomDaoImpl implements ClassroomDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Classroom> getAllClassrooms() {
        Session session = sessionFactory.getCurrentSession();
        List<Classroom> allClassrooms = session.createQuery("from Classroom ", Classroom.class).getResultList();
        return allClassrooms;
    }

    @Override
    public void saveClassroom(int departmentId, Classroom classroom) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, departmentId);
        classroom.setDepartment(department);
        session.saveOrUpdate(classroom);
    }

    @Override
    public Classroom getClassroom(int classroomId) {
        Session session = sessionFactory.getCurrentSession();
        Classroom classroom = session.get(Classroom.class, classroomId);
        return classroom;
    }

    @Override
    public void deleteClassroom(int classroomId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Classroom> query = session.createQuery("delete from  Classroom where id =:classroomId");
        query.setParameter("classroomId", classroomId);
        query.executeUpdate();
    }

    @Override
    public void updateClassroom(int classroomId, String classroomName, int classroomNumber, Department department) {
        Session session = sessionFactory.getCurrentSession();
        Classroom classroom = session.get(Classroom.class, classroomId);
        classroom.setClassroomName(classroomName);
        classroom.setClassroomNumber(classroomNumber);
        classroom.setDepartment(department);
        session.saveOrUpdate(classroom);
    }
}
