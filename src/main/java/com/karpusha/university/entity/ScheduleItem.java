package com.karpusha.university.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "schedule_items")
public class ScheduleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "begin_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginTime;

    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(name = "lesson_name")
    private String lessonName;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "classroom_id")
    @JsonBackReference
    private Classroom classroom;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "student_group_id")
    @JsonBackReference
    private StudentGroup studentGroup;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;

    public ScheduleItem() {
    }

    public ScheduleItem(Date beginTime, Date endTime, String lessonName, Classroom classroom, StudentGroup studentGroup, Teacher teacher) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.lessonName = lessonName;
        this.classroom = classroom;
        this.studentGroup = studentGroup;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleItem that = (ScheduleItem) o;
        return id == that.id &&
                beginTime.equals(that.beginTime) &&
                endTime.equals(that.endTime) &&
                lessonName.equals(that.lessonName) &&
                classroom.equals(that.classroom) &&
                studentGroup.equals(that.studentGroup) &&
                teacher.equals(that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beginTime, endTime, lessonName, classroom, studentGroup, teacher);
    }
}
