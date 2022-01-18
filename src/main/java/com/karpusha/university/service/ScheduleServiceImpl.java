package com.karpusha.university.service;

import com.karpusha.university.dao.ScheduleItemDao;
import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.ScheduleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleItemService {

    @Autowired
    ScheduleItemDao scheduleItemDao;

    @Override
    public List<ScheduleItem> getAllScheduleItems() {
        return scheduleItemDao.getAllScheduleItems();
    }

    @Transactional
    @Override
    public void saveScheduleItem(ScheduleItemDto scheduleItemDto) throws ParseException {
        scheduleItemDao.saveScheduleItem(scheduleItemDto);
    }

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
    public void updateScheduleItem(int scheduleItemId, ScheduleItemDto scheduleItemDto) throws ParseException {
        scheduleItemDao.updateScheduleItem(scheduleItemId, scheduleItemDto);
    }
}
