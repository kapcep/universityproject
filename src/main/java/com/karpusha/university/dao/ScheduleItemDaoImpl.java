package com.karpusha.university.dao;

import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.ScheduleItem;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class ScheduleItemDaoImpl implements ScheduleItemDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ScheduleItem> getAllScheduleItems() {

        List<ScheduleItem> scheduleItems = entityManager.createQuery("from ScheduleItem").getResultList();
        return scheduleItems;
    }

    @Override
    public void saveScheduleItem(ScheduleItemDto scheduleItemDto) throws ParseException {

        Classroom classroom = entityManager.find(Classroom.class, scheduleItemDto.getClassroomId());
        StudentGroup studentGroup = entityManager.find(StudentGroup.class, scheduleItemDto.getStudentGroupId());
        Teacher teacher = entityManager.find(Teacher.class, scheduleItemDto.getTeacherId());
        Date beginDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getBeginDate());
        Date endDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getEndDate());
        entityManager.persist(new ScheduleItem(beginDate, endDate, scheduleItemDto.getLessonName(), classroom, studentGroup, teacher));
    }

    @Override
    public ScheduleItem getScheduleItem(int scheduleItemId) {
        ScheduleItem scheduleItem = entityManager.find(ScheduleItem.class, scheduleItemId);
        return scheduleItem;
    }

    @Override
    public void deleteScheduleItem(int scheduleItemId) {
        ScheduleItem scheduleItem = entityManager.find(ScheduleItem.class, scheduleItemId);
        if (scheduleItem != null) {
            entityManager.remove(scheduleItem);
        }
    }

    @Override
    public void updateScheduleItem(int scheduleItemId, ScheduleItemDto scheduleItemDto) throws ParseException {

        ScheduleItem scheduleItem = getScheduleItem(scheduleItemId);
        Classroom classroom = entityManager.find(Classroom.class, scheduleItemDto.getClassroomId());
        StudentGroup studentGroup = entityManager.find(StudentGroup.class, scheduleItemDto.getStudentGroupId());
        Teacher teacher = entityManager.find(Teacher.class, scheduleItemDto.getTeacherId());
        Date beginDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getBeginDate());
        Date endDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getEndDate());
        scheduleItem.setBeginTime(beginDate);
        scheduleItem.setEndTime(endDate);
        scheduleItem.setLessonName(scheduleItemDto.getLessonName());
        scheduleItem.setClassroom(classroom);
        scheduleItem.setStudentGroup(studentGroup);
        scheduleItem.setTeacher(teacher);
        entityManager.merge(scheduleItem);
    }
}
