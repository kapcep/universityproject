package com.karpusha.university.service;

import com.karpusha.university.entity.ScheduleItem;

import java.util.Date;
import java.util.List;

public interface ScheduleItemService {
    public List<ScheduleItem> getAllScheduleItems();

    public void saveScheduleItem(Date beginDate, Date endDate, String lessonName, int classroomId, int studentGroupId, int teacherId);

    public ScheduleItem getScheduleItem(int scheduleItemId);

    public void deleteScheduleItem(int scheduleItemId);
}
