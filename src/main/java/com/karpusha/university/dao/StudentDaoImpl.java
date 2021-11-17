package com.karpusha.university.dao;

import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {

        Session session = sessionFactory.getCurrentSession();
        List<Student> allStudents = session.createQuery("from Student", Student.class).getResultList();

        return allStudents;
    }

    @Override
    public void saveStudent(Student student, int studentGroupId) {
        Session session = sessionFactory.getCurrentSession();
        StudentGroup studentGroup = session.get(StudentGroup.class, studentGroupId);
        student.setStudentGroup(studentGroup);
        session.saveOrUpdate(student);
    }

    @Override
    public Student getStudent(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, studentId);
        return student;
    }

    @Override
    public void deleteStudent(int studentId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("delete from  Student where id =:studentId");
        query.setParameter("studentId", studentId);
        query.executeUpdate();
    }
}
