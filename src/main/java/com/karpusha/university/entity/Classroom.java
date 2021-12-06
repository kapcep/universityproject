package com.karpusha.university.entity;

import javax.persistence.*;

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

    public Classroom() {
    }

    public Classroom(String classroomName, int classroomNumber) {
        this.classroomName = classroomName;
        this.classroomNumber = classroomNumber;
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

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomName='" + classroomName + '\'' +
                ", classroomNumber=" + classroomNumber +
                '}';
    }
}