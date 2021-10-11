package com.karpusha.university;

import com.karpusha.university.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestMain {
    public static void main(String[] args) {

//        saveFaculty(getSessionFactory(),new Faculty("CTO"));
        //saveStudentGroup(getSessionFactory(), new StudentGroup("BD-2"));
        System.out.println(getFaculty(getSessionFactory(),1).getStudentGroups());
//        saveStudent(getSessionFactory(),new Student("Iurii","Likov",28));
//        saveDepartment(getSessionFactory(),new Department("Deep Dev"));
//        saveTeacher(getSessionFactory(), new Teacher("Olena", "Linkerman", 35));

    }

    private static SessionFactory getSessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Faculty.class)
                .addAnnotatedClass(StudentGroup.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Teacher.class)
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

    private  static  Faculty getFaculty(SessionFactory factory, int id){
        Session session = null;
        Faculty faculty = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            faculty = session.get(Faculty.class, id);
            faculty.getStudentGroups();

        } finally {
            session.close();
            factory.close();
        }
        return faculty;
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

    private static void saveDepartment(SessionFactory factory, Department department) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Faculty faculty = session.get(Faculty.class, 2);
            department.setFaculty(faculty);
            session.save(department);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

    private static void saveTeacher(SessionFactory factory, Teacher teacher) {
        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Department department = session.get(Department.class, 1);
            teacher.setDepartment(department);
            session.save(teacher);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

}

