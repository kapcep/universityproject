package com.karpusha.university.service;

import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.ScheduleItem;

import java.text.ParseException;
import java.util.List;

public interface ScheduleItemService {
    public List<ScheduleItem> getAllScheduleItems();

    public void saveScheduleItem(ScheduleItemDto scheduleItemDto) throws ParseException;

    public ScheduleItem getScheduleItem(int scheduleItemId);

    public void deleteScheduleItem(int scheduleItemId);

    public void updateScheduleItem(int scheduleItemId, ScheduleItemDto scheduleItemDto) throws ParseException;
}
