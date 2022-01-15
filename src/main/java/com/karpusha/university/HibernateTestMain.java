package com.karpusha.university;

import com.karpusha.university.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTestMain {
    public static void main(String[] args) {

//
//        SessionFactory sessionFactory = getSessionFactory();
//        System.out.println(getFaculty(getSessionFactory(),1).getStudentGroups());
//        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.close();
//        sessionFactory.close();
        try (SessionFactory sessionFactory = getSessionFactory()) {
            saveScheduleItem(sessionFactory);
        }
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Faculty.class)
                .addAnnotatedClass(StudentGroup.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Classroom.class)
                .addAnnotatedClass(ScheduleItem.class)
                .buildSessionFactory();
    }

    private static void saveScheduleItem(SessionFactory factory) {
        try (Session session = factory.getCurrentSession()) {
            factory.getCurrentSession();
            session.beginTransaction();
            Classroom classroom = session.get(Classroom.class, 1);
            Teacher teacher = session.get(Teacher.class, 1);
            StudentGroup studentGroup = session.get(StudentGroup.class, 1);

            session.save(new ScheduleItem(new Date(), new Date(), "Philosophy Java", classroom, studentGroup, teacher));
        }
    }


    private static void saveClassroom(SessionFactory factory, Classroom classroom) {
        try (Session session = factory.getCurrentSession()) {
            factory.getCurrentSession();
            session.beginTransaction();
            session.save(classroom);
            session.getTransaction().commit();
        }
    }


    private static void saveFaculty(SessionFactory factory, Faculty faculty) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(faculty);
            session.getTransaction().commit();
        }
    }

    private static Faculty getFaculty(SessionFactory factory, int id) {

        Faculty faculty = null;
        try (Session session = factory.getCurrentSession()) {
            faculty = session.get(Faculty.class, id);
            faculty.getStudentGroups();
        }

        return faculty;
    }

    private static void saveStudentGroup(SessionFactory factory, StudentGroup studentGroup) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Faculty faculty = session.get(Faculty.class, 1);
            studentGroup.setFaculty(faculty);
            session.save(studentGroup);
            session.getTransaction().commit();
        }
    }

    private static void saveStudent(SessionFactory factory, Student student) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            StudentGroup studentGroup = session.get(StudentGroup.class, 2);
            student.setStudentGroup(studentGroup);
            session.save(student);
            session.getTransaction().commit();
        }
    }

    private static void saveDepartment(SessionFactory factory, Department department) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Faculty faculty = session.get(Faculty.class, 2);
            department.setFaculty(faculty);
            session.save(department);
            session.getTransaction().commit();
        }
    }

    private static void saveTeacher(SessionFactory factory, Teacher teacher) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Department department = session.get(Department.class, 1);
            teacher.setDepartment(department);
            session.save(teacher);
            session.getTransaction().commit();
        }
    }

}

