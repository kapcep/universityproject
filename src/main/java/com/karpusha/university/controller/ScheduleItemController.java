package com.karpusha.university.controller;

import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.service.ClassroomService;
import com.karpusha.university.service.ScheduleItemService;
import com.karpusha.university.service.StudentGroupService;
import com.karpusha.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ScheduleItemController {

    @Autowired
    StudentGroupService studentGroupService;

    @Autowired
    ClassroomService classroomService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ScheduleItemService scheduleItemService;

    @RequestMapping("/getAllScheduleItems")
    public String showAllScheduleItems(Model model) {

        return "all-schedule-items";
    }

    @RequestMapping("/testSchedulePage")
    public String showTest(Model model) {
        List<StudentGroup> studentGroups = studentGroupService.getAllStudentGroups();
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        List<Teacher> teachers = teacherService.getAllTeachers();
        ScheduleItemDto scheduleItemDto = new ScheduleItemDto();

        model.addAttribute("studentGroups", studentGroups);
        model.addAttribute("classrooms", classrooms);
        model.addAttribute("teachers", teachers);
        model.addAttribute("scheduleItemDto", scheduleItemDto);
        return "test-schedule-page";
    }

    @PostMapping("/addScheduleItem")
    public String addScheduleItem(@ModelAttribute ScheduleItemDto scheduleItemDto, Model model) throws ParseException {

        Date beginDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getBeginDate());
        Date endDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getEndDate());
        scheduleItemService.saveScheduleItem(beginDate, endDate, scheduleItemDto.getLessonName(),
                scheduleItemDto.getClassroomId(), scheduleItemDto.getStudentGroupId(), scheduleItemDto.getTeacherId());

        return "all-schedule-items";
    }

}
