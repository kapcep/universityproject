package com.karpusha.university.controller;

import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.ScheduleItem;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.service.ClassroomService;
import com.karpusha.university.service.ScheduleItemService;
import com.karpusha.university.service.StudentGroupService;
import com.karpusha.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        model.addAttribute("scheduleItems", scheduleItems);
        return "all-schedule-items";
    }

    @RequestMapping("/add-schedule-item")
    public String showAddScheduleItemForm(Model model) {
        List<StudentGroup> studentGroups = studentGroupService.getAllStudentGroups();
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        List<Teacher> teachers = teacherService.getAllTeachers();
        ScheduleItemDto scheduleItemDto = new ScheduleItemDto();

        model.addAttribute("studentGroups", studentGroups);
        model.addAttribute("classrooms", classrooms);
        model.addAttribute("teachers", teachers);
        model.addAttribute("scheduleItemDto", scheduleItemDto);
        return "add-schedule-item";
    }

    @PostMapping("/addScheduleItem")
    public String addScheduleItem(@ModelAttribute ScheduleItemDto scheduleItemDto, Model model) throws ParseException {

        Date beginDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getBeginDate());
        Date endDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getEndDate());
        scheduleItemService.saveScheduleItem(beginDate, endDate, scheduleItemDto.getLessonName(),
                scheduleItemDto.getClassroomId(), scheduleItemDto.getStudentGroupId(), scheduleItemDto.getTeacherId());

        return "all-schedule-items";
    }

    @GetMapping("/deleteScheduleItem/{scheduleItemId}")
    public String deleteFaculty(@PathVariable("scheduleItemId") int scheduleItemId, Model model) {
        scheduleItemService.deleteScheduleItem(scheduleItemId);
        return "redirect:/getAllScheduleItems";
    }

    @GetMapping("/editScheduleItem/{scheduleItemId}")
    public String showScheduleItemUpdateForm(@PathVariable("scheduleItemId")
                                                     int scheduleItemId, Model model) {
        ScheduleItem scheduleItem = scheduleItemService.getScheduleItem(scheduleItemId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        ScheduleItemDto scheduleItemDto = new ScheduleItemDto(dateFormat.format(scheduleItem.getBeginTime()),
                dateFormat.format(scheduleItem.getEndTime()), scheduleItem.getLessonName(),
                scheduleItem.getClassroom().getId(), scheduleItem.getStudentGroup().getId(),
                scheduleItem.getTeacher().getId());
        model.addAttribute("scheduleItemId", scheduleItemId);
        model.addAttribute("scheduleItemDto",scheduleItemDto);


        return "update-schedule-item";
    }

    @PostMapping("/updateScheduleItem/{scheduleItemId}")
    public String updateScheduleItem(@PathVariable("scheduleItemId") int scheduleItemId,
                                     @ModelAttribute ScheduleItemDto scheduleItemDto, Model model) throws ParseException {
        Date beginDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getBeginDate());
        Date endDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getEndDate());
        scheduleItemService.updateScheduleItem(scheduleItemId, beginDate, endDate, scheduleItemDto.getLessonName(),
                scheduleItemDto.getClassroomId(), scheduleItemDto.getStudentGroupId(), scheduleItemDto.getTeacherId());

        return "redirect:/getAllScheduleItems";
    }
}
