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

}
