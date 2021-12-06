package com.karpusha.university.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule_time")
public class ScheduleTime {
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

    public ScheduleTime() {
    }

    public ScheduleTime(Date beginTime, Date endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
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

    @Override
    public String toString() {
        return "ScheduleTime{" +
                "beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}
