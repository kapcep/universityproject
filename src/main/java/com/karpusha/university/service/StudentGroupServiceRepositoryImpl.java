package com.karpusha.university.service;

import com.karpusha.university.dao.StudentGroupRepository;
import com.karpusha.university.entity.Faculty;
import com.karpusha.university.entity.Student;
import com.karpusha.university.entity.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentGroupServiceRepositoryImpl implements StudentGroupService {

    @Autowired
    FacultyServiceRepositoryImpl facultyServiceRepositoryImpl;
    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Override
    public List<StudentGroup> getAllStudentGroups() {
        return studentGroupRepository.findAll();
    }

    @Override
    public void saveStudentGroup(int facultyId, StudentGroup studentGroup) {
        Faculty faculty = facultyServiceRepositoryImpl.getFaculty(facultyId);
        studentGroup.setFaculty(faculty);
        studentGroupRepository.save(studentGroup);
    }

    @Override
    public StudentGroup getStudentGroup(int id) {
        StudentGroup studentGroup = null;
        Optional<StudentGroup> optionalStudentGroup = studentGroupRepository.findById(id);
        if (optionalStudentGroup.isPresent()) {
            studentGroup = optionalStudentGroup.get();
        }
        return studentGroup;
    }

    @Override
    public int deleteStudentGroup(int id) {
        StudentGroup studentGroup = getStudentGroup(id);
        int facultyId = studentGroup.getFaculty().getId();
        studentGroupRepository.delete(studentGroup);
        return facultyId;
    }

    @Override
    public void updateStudentGroupName(int studentGroupId, String studentGroupName) {
        StudentGroup studentGroup = getStudentGroup(studentGroupId);
        studentGroup.setGroupName(studentGroupName);
        studentGroupRepository.save(studentGroup);

    }

    @Override
    public List<Student> getStudentsOfStudentGroup(int studentGroupId) {
        StudentGroup studentGroup = getStudentGroup(studentGroupId);
        return studentGroup.getStudents();
    }
}
