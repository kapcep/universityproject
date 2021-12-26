package com.karpusha.university.service;

import com.karpusha.university.dao.ScheduleItemDao;
import com.karpusha.university.entity.ScheduleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleItemService {

    @Autowired
    ScheduleItemDao scheduleItemDao;

    @Transactional
    @Override
    public List<ScheduleItem> getAllScheduleItems() {
        return scheduleItemDao.getAllScheduleItems();
    }

    @Transactional
    @Override
    public void saveScheduleItem(Date beginDate, Date endDate, String lessonName, int classroomId, int studentGroupId, int teacherId) {
        scheduleItemDao.saveScheduleItem(beginDate, endDate, lessonName, classroomId, studentGroupId, teacherId);
    }

    @Transactional
    @Override
    public ScheduleItem getScheduleItem(int scheduleItemId) {
        return scheduleItemDao.getScheduleItem(scheduleItemId);
    }

    @Transactional
    @Override
    public void deleteScheduleItem(int scheduleItemId) {
        scheduleItemDao.deleteScheduleItem(scheduleItemId);
    }

    @Transactional
    @Override
    public void updateScheduleItem(int scheduleItemId, Date beginDate, Date endDate, String lessonName,
                                   int classroomId, int studentGroupId, int teacherId) {
        scheduleItemDao.updateScheduleItem(scheduleItemId, beginDate, endDate, lessonName,
                classroomId, studentGroupId, teacherId);
    }
}
