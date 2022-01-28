package com.karpusha.university.service;

import com.karpusha.university.dao.ScheduleItemRepository;
import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.ScheduleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ScheduleItemServiceRepositoryImpl implements ScheduleItemService {

    @Autowired
    ScheduleItemRepository scheduleItemRepository;

    @Override
    public List<ScheduleItem> getAllScheduleItems() {
        return scheduleItemRepository.findAll();
    }

    @Override
    public void saveScheduleItem(ScheduleItemDto scheduleItemDto) throws ParseException {
        ScheduleItem scheduleItem = new ScheduleItem();

    }

    @Override
    public ScheduleItem getScheduleItem(int scheduleItemId) {
        return null;
    }

    @Override
    public void deleteScheduleItem(int scheduleItemId) {

    }

    @Override
    public void updateScheduleItem(int scheduleItemId, ScheduleItemDto scheduleItemDto) throws ParseException {

    }
}
