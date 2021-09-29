package com.karpusha.university.entity;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_surname")
    private String studentSurName;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "student_group_id")
    StudentGroup studentGroup;

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

//    public void setId(int id) {
//        this.id = id;
//    }

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
}
