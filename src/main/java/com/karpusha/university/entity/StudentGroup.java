package com.karpusha.university.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_groups")
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "group_name")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "studentGroup")
    private List<Student> students;

    public StudentGroup() {
    }

    public StudentGroup(String groupName) {
        this.groupName = groupName;
    }

    public void addStudentToFaculty(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        student.setStudentGroup(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
