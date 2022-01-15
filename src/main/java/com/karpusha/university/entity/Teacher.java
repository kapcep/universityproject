package com.karpusha.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "teacher_surname")
    private String teacherSurName;

    @Column(name = "age")
    private int age;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Department department;

    public Teacher() {
    }

    public Teacher(String teacherName, String teacherSurName, int age) {
        this.teacherName = teacherName;
        this.teacherSurName = teacherSurName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurName() {
        return teacherSurName;
    }

    public void setTeacherSurName(String teacherSurName) {
        this.teacherSurName = teacherSurName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSurName='" + teacherSurName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                age == teacher.age &&
                teacherName.equals(teacher.teacherName) &&
                teacherSurName.equals(teacher.teacherSurName) &&
                department.equals(teacher.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherName, teacherSurName, age, department);
    }
}
