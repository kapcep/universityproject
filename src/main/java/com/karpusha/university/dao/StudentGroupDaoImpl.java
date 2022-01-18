package com.karpusha.university.dao;

import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.StudentGroup;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentGroupDaoImpl implements StudentGroupDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<StudentGroup> getAllStudentGroups() {
        Session session = entityManager.unwrap(Session.class);
        List<StudentGroup> allStudentGroups = session.createQuery("from StudentGroup ", StudentGroup.class).getResultList();
        return allStudentGroups;
    }

    @Override
    public void saveStudentGroup(int facultyId, StudentGroup studentGroup) {
        Session session = entityManager.unwrap(Session.class);
        Faculty faculty = session.get(Faculty.class, facultyId);
        studentGroup.setFaculty(faculty);
        session.saveOrUpdate(studentGroup);
    }

    @Override
    public StudentGroup getStudentGroup(int id) {
        Session session = entityManager.unwrap(Session.class);
        StudentGroup studentGroup = session.get(StudentGroup.class, id);
        return studentGroup;
    }

    @Override
    public void deleteStudentGroup(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<StudentGroup> query = session.createQuery("delete from  StudentGroup where id =:studentGroupId");
        query.setParameter("studentGroupId", id);
        query.executeUpdate();
    }

    @Override
    public void updateStudentGroupName(int studentGroupId, String studentGroupName) {
        Session session = entityManager.unwrap(Session.class);
        StudentGroup studentGroup = session.get(StudentGroup.class, studentGroupId);
        studentGroup.setGroupName(studentGroupName);
        session.saveOrUpdate(studentGroup);
    }
}
