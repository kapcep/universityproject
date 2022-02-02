package com.karpusha.university.dto;

import com.karpusha.university.validation.CompareBeginAndEndLessonDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ScheduleItemDto {

    @NotBlank(message = "Please choose begin time of lesson")
    private String beginDate;

    @NotBlank(message = "Please choose end time of lesson")
    @CompareBeginAndEndLessonDate
    private String endDate;

    @Size(min = 1, message = "Lesson name must have at least 1 symbols")
    @NotBlank(message = "Lesson name can not be empty")
    private String lessonName;

    private Integer classroomId;

    private Integer studentGroupId;

    private Integer teacherId;

    public ScheduleItemDto() {
    }

    public ScheduleItemDto(String beginDate, String endDate, String lessonName, Integer classroomId, Integer studentGroupId, Integer teacherId) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.lessonName = lessonName;
        this.classroomId = classroomId;
        this.studentGroupId = studentGroupId;
        this.teacherId = teacherId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(Integer studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
