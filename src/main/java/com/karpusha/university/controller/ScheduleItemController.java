package com.karpusha.university.controller;

import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.entity.Teacher;
import com.karpusha.university.service.ClassroomService;
import com.karpusha.university.service.StudentGroupService;
import com.karpusha.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ScheduleItemController {

    @Autowired
    StudentGroupService studentGroupService;

    @Autowired
    ClassroomService classroomService;

    @Autowired
    TeacherService teacherService;

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
    public String addScheduleItem(@ModelAttribute ScheduleItemDto scheduleItemDto, Model model) {
        System.out.println("--------------------------------------");
        System.out.println(classroomService.getClassroom(scheduleItemDto.getClassroomId()));
        System.out.println(studentGroupService.getStudentGroup(scheduleItemDto.getStudentGroupId()));
        System.out.println(teacherService.getTeacher(scheduleItemDto.getTeacherId()));
        System.out.println(scheduleItemDto.getBeginDate());
        System.out.println(scheduleItemDto.getEndDate());
        System.out.println(scheduleItemDto.getLessonName());
        return "all-schedule-items";
    }

}
