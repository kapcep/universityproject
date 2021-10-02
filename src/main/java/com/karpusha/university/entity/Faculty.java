package com.karpusha.university.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "faculty_name")
    private String name;

    @OneToMany(mappedBy = "faculty")
    private List<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "faculty")
    private List<Department> departments;


    public Faculty() {
    }

    public Faculty(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addStudentGroupToFaculty(StudentGroup studentGroup) {
        if (studentGroups == null) {
            studentGroups = new ArrayList<>();
        }
        studentGroups.add(studentGroup);
        studentGroup.setFaculty(this);
    }

    public void addDepartmentToFaculty(Department department) {
        if (departments == null) {
            departments = new ArrayList<>();
        }
        departments.add(department);
        department.setFaculty(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}