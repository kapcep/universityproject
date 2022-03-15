package com.karpusha.university.controller;

import com.karpusha.university.dto.DatePickerDto;
import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.ScheduleItem;
import com.karpusha.university.entity.Student;
import com.karpusha.university.service.ScheduleItemServiceRepositoryImpl;
import com.karpusha.university.service.StudentServiceImpl;
import com.karpusha.university.service.StudentServiceRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/scheduleItems")
public class ScheduleItemRestController {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduleItemRestController.class);

    @Autowired
    ScheduleItemServiceRepositoryImpl scheduleItemService;

    StudentServiceImpl studentService;

    @GetMapping("")
    public List<ScheduleItem> showAllScheduleItems() {
        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        return scheduleItems;
    }

    @PostMapping("")
    public ScheduleItemDto addScheduleItem(@RequestBody ScheduleItemDto scheduleItemDto) throws ParseException {
        scheduleItemService.saveScheduleItem(scheduleItemDto);
        return scheduleItemDto;
    }

    @PutMapping("")
    public String updateScheduleItem(@RequestBody ScheduleItemDto scheduleItemDto) throws ParseException {
        scheduleItemService.saveScheduleItem(scheduleItemDto);
        return "redirect:/getAllScheduleItems";
    }

    @DeleteMapping("/{scheduleItemId}")
    public String deleteScheduleItem(@PathVariable("scheduleItemId") int scheduleItemId) {
        scheduleItemService.deleteScheduleItem(scheduleItemId);
        return "ScheduleItem with id = " + scheduleItemId + " was deleted";
    }

    @GetMapping("/studentDay/{studentId}")
    public List<ScheduleItem> getStudentDaySchedule(@PathVariable("studentId") int studentId,
                                                    @RequestBody DatePickerDto datePickerDto) {
        LOG.info("Date: " + datePickerDto.getChosenDate());
        LOG.info("Student ID: " + studentId);
        Student student = studentService.getStudent(studentId);
        LOG.info("Student: " + student);
        int studentGroupId = student.getStudentGroup().getId();
        LOG.info("Group ID: " + studentGroupId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        scheduleItems = scheduleItems
                .stream()
                .filter(s -> s.getStudentGroup().getId() == studentGroupId &&
                        dateFormat.format(s.getBeginTime()).equals(datePickerDto.getChosenDate()))
                .collect(Collectors.toList());

        return scheduleItems;
    }
}
