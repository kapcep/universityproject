package com.karpusha.university.dao;

import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.ScheduleItem;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ScheduleItemDaoImpl implements ScheduleItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ScheduleItem> getAllScheduleItems() {
        Session session = sessionFactory.getCurrentSession();
        List<ScheduleItem> scheduleItems = session.createQuery("from ScheduleItem", ScheduleItem.class).getResultList();
        return scheduleItems;
    }

    @Override
    public void saveScheduleItem(Date beginDate, Date endDate, String lessonName, int classroomId, int studentGroupId, int teacherId) {
        Session session = sessionFactory.getCurrentSession();
        Classroom classroom = session.get(Classroom.class, classroomId);
        StudentGroup studentGroup = session.get(StudentGroup.class, studentGroupId);
        Teacher teacher = session.get(Teacher.class, teacherId);
        session.saveOrUpdate(new ScheduleItem(beginDate, endDate, lessonName, classroom, studentGroup, teacher));
    }

    @Override
    public ScheduleItem getScheduleItem(int scheduleItemId) {
        Session session = sessionFactory.getCurrentSession();
        ScheduleItem scheduleItem = session.get(ScheduleItem.class, scheduleItemId);
        return scheduleItem;
    }

    @Override
    public void deleteScheduleItem(int scheduleItemId) {
        Session session = sessionFactory.getCurrentSession();
        Query<ScheduleItem> query = session.createQuery("delete from  ScheduleItem where id =:scheduleItemId");
        query.setParameter("scheduleItemId", scheduleItemId);
        query.executeUpdate();
    }

    @Override
    public void updateScheduleItem(int scheduleItemId, Date beginDate, Date endDate, String lessonName,
                                   int classroomId, int studentGroupId, int teacherId) {
        Session session = sessionFactory.getCurrentSession();
        ScheduleItem scheduleItem = session.get(ScheduleItem.class, scheduleItemId);
        Classroom classroom = session.get(Classroom.class, classroomId);
        StudentGroup studentGroup = session.get(StudentGroup.class, studentGroupId);
        Teacher teacher = session.get(Teacher.class,teacherId);
        scheduleItem.setBeginTime(beginDate);
        scheduleItem.setEndTime(endDate);
        scheduleItem.setLessonName(lessonName);
        scheduleItem.setClassroom(classroom);
        scheduleItem.setStudentGroup(studentGroup);
        scheduleItem.setTeacher(teacher);

    }
}
