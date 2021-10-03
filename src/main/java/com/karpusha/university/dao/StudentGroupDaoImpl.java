package com.karpusha.university.dao;

import com.karpusha.university.entity.StudentGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentGroupDaoImpl implements StudentGroupDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<StudentGroup> getAllStudentGroups() {
        Session session = sessionFactory.getCurrentSession();
        List<StudentGroup> allStudentGroups = session.createQuery("from StudentGroup ", StudentGroup.class).getResultList();

        return allStudentGroups;
    }

    @Override
    public void saveStudentGroup(StudentGroup studentGroup) {

    }

    @Override
    public StudentGroup getStudentGroup(int id) {
        return null;
    }

    @Override
    public void deleteStudentGroup(int id) {

    }
}
