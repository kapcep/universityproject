package com.karpusha.university.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "classroom_name")
    private String classroomName;

    @Column(name = "classroom_number")
    private int classroomNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    public Classroom() {
    }

    public Classroom(String classroomName, int classroomNumber, Department department) {
        this.classroomName = classroomName;
        this.classroomNumber = classroomNumber;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomName='" + classroomName + '\'' +
                ", classroomNumber=" + classroomNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id == classroom.id &&
                classroomNumber == classroom.classroomNumber &&
                classroomName.equals(classroom.classroomName) &&
                department.equals(classroom.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classroomName, classroomNumber, department);
    }
}
