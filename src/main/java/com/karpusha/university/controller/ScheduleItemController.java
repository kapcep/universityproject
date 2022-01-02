package com.karpusha.university.controller;

import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.*;
import com.karpusha.university.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    StudentService studentService;

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

        return "redirect:/getAllScheduleItems";
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

        List<StudentGroup> studentGroups = studentGroupService.getAllStudentGroups();
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("scheduleItemId", scheduleItemId);
        model.addAttribute("scheduleItemDto", scheduleItemDto);
        model.addAttribute("studentGroups", studentGroups);
        model.addAttribute("classrooms", classrooms);
        model.addAttribute("teachers", teachers);

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

    @GetMapping("/getStudentDaySchedule/{studentId}")
    public String getStudentDaySchedule(@PathVariable("studentId")
                                                int studentId, Model model) {
        Student student = studentService.getStudent(studentId);
        int studentGroupId = student.getStudentGroup().getId();
        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        scheduleItems = scheduleItems
                .stream()
                .filter(s -> s.getStudentGroup().getId() == studentGroupId)
                .collect(Collectors.toList());
        model.addAttribute("scheduleItems", scheduleItems);
        return "student-day-schedule";
    }

}
