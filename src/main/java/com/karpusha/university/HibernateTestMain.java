package com.karpusha.university;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestMain {
    public static void main(String[] args) {

        saveFaculty(getSessionFactory(),new Faculty("TT"));
//        saveStudentGroup(getSessionFactory(),new StudentGroup("BD-2"));
//        saveStudent(getSessionFactory(),new Student("Iurii","Likov",28));


    }

    private static SessionFactory getSessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Faculty.class)
                .addAnnotatedClass(StudentGroup.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    private static void saveFaculty(SessionFactory factory, Faculty faculty) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(faculty);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

    private static void saveStudentGroup(SessionFactory factory, StudentGroup studentGroup) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Faculty faculty = session.get(Faculty.class, 1);
            studentGroup.setFaculty(faculty);
            session.save(studentGroup);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

    private static void saveStudent(SessionFactory factory, Student student) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            StudentGroup studentGroup = session.get(StudentGroup.class, 2);
            student.setStudentGroup(studentGroup);
            session.save(student);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

