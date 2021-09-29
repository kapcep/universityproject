package com.karpusha.university;

import com.karpusha.university.entity.Faculty;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestMain {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Faculty.class).buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Faculty faculty = new Faculty("ML");
            session.beginTransaction();
            session.save(faculty);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
