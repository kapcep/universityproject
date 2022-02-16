package com.karpusha.university.dao;

import com.karpusha.university.entity.Department;
import com.karpusha.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Teacher> getAllTeachers() {

        List<Teacher> allTeachers = entityManager.createQuery("from Teacher").getResultList();
        return allTeachers;
    }

    @Override
    public void saveTeacher(Teacher teacher, int departmentId) {

        Department department = entityManager.find(Department.class, departmentId);
        if (teacher != null) {
            if (teacher.getId() == 0) {
                teacher.setDepartment(department);
                entityManager.persist(teacher);
            } else {
                teacher.setDepartment(department);
                entityManager.merge(teacher);
            }
        }
    }

    @Override
    public Teacher getTeacher(int teacherId) {
        Teacher teacher = entityManager.find(Teacher.class, teacherId);
        return teacher;
    }

    @Override
    public void deleteTeacher(int teacherId) {
        Teacher teacher = getTeacher(teacherId);
        if (teacher != null) {
            entityManager.remove(teacher);
        }
    }
}
