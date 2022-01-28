package com.karpusha.university.service;

import com.karpusha.university.dao.ClassroomRepository;
import com.karpusha.university.dao.DepartmentRepository;
import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceRepositoryImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public void saveClassroom(int departmentId, Classroom classroom) {
        Department department = departmentRepository.getById(departmentId);
        classroom.setDepartment(department);
        classroomRepository.save(classroom);
    }

    @Override
    public Classroom getClassroom(int classroomId) {
        return classroomRepository.getById(classroomId);
    }

    @Override
    public int deleteClassroom(int classroomId) {
        Classroom classroom = getClassroom(classroomId);
        int departmentId = classroom.getDepartment().getId();
        return departmentId;
    }

    @Override
    public void updateClassroom(int classroomId, String classroomName, int classroomNumber, Department department) {
        Classroom classroom = getClassroom(classroomId);
        classroom.setClassroomName(classroomName);
        classroom.setClassroomNumber(classroomNumber);
        classroom.setDepartment(department);
        classroomRepository.save(classroom);
    }
}
