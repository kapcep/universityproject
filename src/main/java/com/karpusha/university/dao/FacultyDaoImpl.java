package com.karpusha.university.dao;

import com.karpusha.university.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacultyDaoImpl implements FacultyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Faculty> getAllFaculties() {

        Session session = sessionFactory.getCurrentSession();
        List<Faculty> allFaculties = session.createQuery("from Faculty", Faculty.class).getResultList();

        return allFaculties;
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(faculty);
    }

    @Override
    public Faculty getFaculty(int id) {
        Session session = sessionFactory.getCurrentSession();
        Faculty faculty = session.get(Faculty.class, id);
        faculty.getStudentGroups();
        return faculty;
    }

    @Override
    public void deleteFaculty(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Faculty> query = session.createQuery("delete from  Faculty where id =:facultyId");
        query.setParameter("facultyId",id);
        query.executeUpdate();
    }
}
