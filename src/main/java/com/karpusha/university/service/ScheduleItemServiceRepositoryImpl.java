package com.karpusha.university.service;

import com.karpusha.university.dao.ClassroomRepository;
import com.karpusha.university.dao.ScheduleItemRepository;
import com.karpusha.university.dao.StudentGroupRepository;
import com.karpusha.university.dao.TeacherRepository;
import com.karpusha.university.dto.ScheduleItemDto;
import com.karpusha.university.entity.Classroom;
import com.karpusha.university.entity.ScheduleItem;
import com.karpusha.university.entity.StudentGroup;
import com.karpusha.university.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleItemServiceRepositoryImpl implements ScheduleItemService {

    @Autowired
    ScheduleItemRepository scheduleItemRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    StudentGroupRepository studentGroupRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<ScheduleItem> getAllScheduleItems() {
        return scheduleItemRepository.findAll();
    }

    @Override
    public void saveScheduleItem(ScheduleItemDto scheduleItemDto) throws ParseException {
        ScheduleItem scheduleItem = new ScheduleItem();
        Date beginDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getBeginDate());
        Date endDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getEndDate());
        Classroom classroom = classroomRepository.getById(scheduleItemDto.getClassroomId());
        StudentGroup studentGroup = studentGroupRepository.getById(scheduleItemDto.getStudentGroupId());
        Teacher teacher = teacherRepository.getById(scheduleItemDto.getTeacherId());

        scheduleItem.setBeginTime(beginDate);
        scheduleItem.setEndTime(endDate);
        scheduleItem.setLessonName(scheduleItemDto.getLessonName());
        scheduleItem.setClassroom(classroom);
        scheduleItem.setStudentGroup(studentGroup);
        scheduleItem.setTeacher(teacher);

        scheduleItemRepository.save(scheduleItem);
    }

    @Override
    public ScheduleItem getScheduleItem(int scheduleItemId) {
        return scheduleItemRepository.getById(scheduleItemId);
    }

    @Override
    public void deleteScheduleItem(int scheduleItemId) {
        ScheduleItem scheduleItem = getScheduleItem(scheduleItemId);
        scheduleItemRepository.delete(scheduleItem);
    }

    @Override
    public void updateScheduleItem(int scheduleItemId, ScheduleItemDto scheduleItemDto) throws ParseException {
        ScheduleItem scheduleItem = getScheduleItem(scheduleItemId);
        Date beginDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getBeginDate());
        Date endDate = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(scheduleItemDto.getEndDate());
        Classroom classroom = classroomRepository.getById(scheduleItemDto.getClassroomId());
        StudentGroup studentGroup = studentGroupRepository.getById(scheduleItemDto.getStudentGroupId());
        Teacher teacher = teacherRepository.getById(scheduleItemDto.getTeacherId());

        scheduleItem.setBeginTime(beginDate);
        scheduleItem.setEndTime(endDate);
        scheduleItem.setLessonName(scheduleItemDto.getLessonName());
        scheduleItem.setClassroom(classroom);
        scheduleItem.setStudentGroup(studentGroup);
        scheduleItem.setTeacher(teacher);

        scheduleItemRepository.save(scheduleItem);
    }
}
