package com.karpusha.university.service;

import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.Department;

import java.util.List;

public interface ClassroomService {
    public List<Classroom> getAllClassrooms();

    public void saveClassroom(int departmentId, Classroom classroom);

    public Classroom getClassroom(int classroomId);

    public int deleteClassroom(int classroomId);

    public void updateClassroom(int classroomId, String classroomName, int classroomNumber, Department department);
}
