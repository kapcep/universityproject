package com.karpusha.university.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "student_group_id")
    @JsonBackReference
    StudentGroup studentGroup;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "student_name")
    @Size(min = 2, message = "Student name must have at least 2 symbols")
    @NotBlank(message = "Student name can not be empty")
    private String studentName;

    @Column(name = "student_surname")
    @Size(min = 2, message = "Student surName must have at least 2 symbols")
    @NotBlank(message = "Student surName can not be empty")
    private String studentSurName;

    @Column(name = "age")
    @Min(value = 16, message = "Student must have at least 16 years old")
    private int age;

    public Student() {
    }

    public Student(String studentName, String studentSurName, int age) {
        this.studentName = studentName;
        this.studentSurName = studentSurName;
        this.age = age;
        this.studentGroup = studentGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurName() {
        return studentSurName;
    }

    public void setStudentSurName(String studentSurName) {
        this.studentSurName = studentSurName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentSurName='" + studentSurName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                age == student.age &&
                studentGroup.equals(student.studentGroup) &&
                studentName.equals(student.studentName) &&
                studentSurName.equals(student.studentSurName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentGroup, id, studentName, studentSurName, age);
    }
}
