package com.karpusha.university.controller;

import com.karpusha.university.dto.DatePickerDto;
import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.*;
import com.karpusha.university.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ScheduleItemController {

    @Autowired
    StudentGroupServiceImpl studentGroupService;

    @Autowired
    ClassroomServiceImpl classroomService;

    @Autowired
    TeacherServiceImpl teacherService;

    @Autowired
    ScheduleServiceImpl scheduleItemService;

    @Autowired
    StudentServiceRepositoryImpl studentService;

    @GetMapping("/getAllScheduleItems")
    public String showAllScheduleItems(Model model) {
        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        model.addAttribute("scheduleItems", scheduleItems);
        return "all-schedule-items";
    }

    @GetMapping("/add-schedule-item")
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
    public String addScheduleItem(@Valid @ModelAttribute ScheduleItemDto scheduleItemDto,
                                  BindingResult bindingResult, Model model) throws ParseException {
        if (bindingResult.hasErrors()) {
            List<StudentGroup> studentGroups = studentGroupService.getAllStudentGroups();
            List<Classroom> classrooms = classroomService.getAllClassrooms();
            List<Teacher> teachers = teacherService.getAllTeachers();

            model.addAttribute("studentGroups", studentGroups);
            model.addAttribute("classrooms", classrooms);
            model.addAttribute("teachers", teachers);
            model.addAttribute("scheduleItemDto", scheduleItemDto);
            return "add-schedule-item";
        }

        scheduleItemService.saveScheduleItem(scheduleItemDto);
        return "redirect:/getAllScheduleItems";
    }

    @GetMapping("/deleteScheduleItem/{scheduleItemId}")
    public String deleteScheduleItem(@PathVariable("scheduleItemId") int scheduleItemId, Model model) {
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

        scheduleItemService.updateScheduleItem(scheduleItemId, scheduleItemDto);

        return "redirect:/getAllScheduleItems";
    }

    @GetMapping("/getStudentDaySchedulePage/{studentId}")
    public String showFormStudentDaySchedule(@PathVariable("studentId")
                                                     int studentId, Model model) {
        Student student = studentService.getStudent(studentId);
        DatePickerDto datePickerDto = new DatePickerDto();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datePickerDto.setChosenDate("2021-12-01");
        model.addAttribute("student", student);
        model.addAttribute("datePickerDto", datePickerDto);
        return "student-day-schedule";
    }

    @PostMapping("/getStudentDayScheduleList/{studentId}")
    public String getStudentDaySchedule(@PathVariable("studentId") int studentId, @ModelAttribute DatePickerDto datePickerDto,
                                        Model model) throws ParseException {
        Student student = studentService.getStudent(studentId);
        int studentGroupId = student.getStudentGroup().getId();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        scheduleItems = scheduleItems
                .stream()
                .filter(s -> s.getStudentGroup().getId() == studentGroupId &&
                        dateFormat.format(s.getBeginTime()).equals(datePickerDto.getChosenDate()))
                .collect(Collectors.toList());
        model.addAttribute("scheduleItems", scheduleItems);

        return "all-schedule-items";
    }

    @GetMapping("/getStudentMonthSchedulePage/{studentId}")
    public String showFormStudentMonthSchedule(@PathVariable("studentId")
                                                       int studentId, Model model) {
        Student student = studentService.getStudent(studentId);
        DatePickerDto datePickerDto = new DatePickerDto();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        datePickerDto.setChosenDate("2021-12");
        model.addAttribute("student", student);
        model.addAttribute("datePickerDto", datePickerDto);
        return "student-month-schedule";
    }

    @PostMapping("/getStudentMonthScheduleList/{studentId}")
    public String getStudentMonthSchedule(@PathVariable("studentId") int studentId, @ModelAttribute DatePickerDto datePickerDto,
                                          Model model) throws ParseException {
        Student student = studentService.getStudent(studentId);
        int studentGroupId = student.getStudentGroup().getId();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        scheduleItems = scheduleItems
                .stream()
                .filter(s -> s.getStudentGroup().getId() == studentGroupId &&
                        dateFormat.format(s.getBeginTime()).equals(datePickerDto.getChosenDate()))
                .collect(Collectors.toList());
        model.addAttribute("scheduleItems", scheduleItems);

        return "all-schedule-items";
    }

    @GetMapping("/getTeacherDaySchedulePage/{teacherId}")
    public String showFormTeacherDaySchedule(@PathVariable("teacherId")
                                                     int teacherId, Model model) {

        Teacher teacher = teacherService.getTeacher(teacherId);
        DatePickerDto datePickerDto = new DatePickerDto();
        datePickerDto.setChosenDate("2021-12-01");
        model.addAttribute("teacher", teacher);
        model.addAttribute("datePickerDto", datePickerDto);
        return "teacher-day-schedule";
    }

    @PostMapping("/getTeacherDayScheduleList/{teacherId}")
    public String getTeacherDaySchedule(@PathVariable("teacherId") int teacherId, @ModelAttribute DatePickerDto datePickerDto,
                                        Model model) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        scheduleItems = scheduleItems
                .stream()
                .filter(s -> s.getTeacher().getId() == teacherId &&
                        dateFormat.format(s.getBeginTime()).equals(datePickerDto.getChosenDate()))
                .collect(Collectors.toList());
        model.addAttribute("scheduleItems", scheduleItems);

        return "all-schedule-items";
    }

    @GetMapping("/getTeacherMonthSchedulePage/{teacherId}")
    public String showFormTeacherMonthSchedule(@PathVariable("teacherId")
                                                       int teacherId, Model model) {

        Teacher teacher = teacherService.getTeacher(teacherId);
        DatePickerDto datePickerDto = new DatePickerDto();
        datePickerDto.setChosenDate("2021-12");
        model.addAttribute("teacher", teacher);
        model.addAttribute("datePickerDto", datePickerDto);
        return "teacher-month-schedule";
    }

    @PostMapping("/getTeacherMonthScheduleList/{teacherId}")
    public String getTeacherMonthSchedule(@PathVariable("teacherId") int teacherId, @ModelAttribute DatePickerDto datePickerDto,
                                          Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        List<ScheduleItem> scheduleItems = scheduleItemService.getAllScheduleItems();
        scheduleItems = scheduleItems
                .stream()
                .filter(s -> s.getTeacher().getId() == teacherId &&
                        dateFormat.format(s.getBeginTime()).equals(datePickerDto.getChosenDate()))
                .collect(Collectors.toList());
        model.addAttribute("scheduleItems", scheduleItems);

        return "all-schedule-items";
    }
}
