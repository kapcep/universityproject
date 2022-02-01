package com.karpusha.university.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "faculty_name")
    @Size(min = 2, message = "Name must be minimum 2 symbols")
    @NotBlank(message = "Name can not be empty")
    private String name;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id == faculty.id &&
                name.equals(faculty.name) &&
                studentGroups.equals(faculty.studentGroups) &&
                departments.equals(faculty.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, studentGroups, departments);
    }
}