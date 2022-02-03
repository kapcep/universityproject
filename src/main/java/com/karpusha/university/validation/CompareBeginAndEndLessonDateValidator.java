package com.karpusha.university.validation;

import com.karpusha.university.dto.ScheduleItemDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompareBeginAndEndLessonDateValidator implements ConstraintValidator<CompareBeginAndEndLessonDateInScheduleItemDto, ScheduleItemDto> {

    private String validatorMessage;

    @Override
    public void initialize(CompareBeginAndEndLessonDateInScheduleItemDto compareBeginAndEndLessonDateInScheduleItemDto) {
        validatorMessage = compareBeginAndEndLessonDateInScheduleItemDto.message();
    }

    @Override
    public boolean isValid(ScheduleItemDto scheduleItemDto, ConstraintValidatorContext constraintValidatorContext) {
        if (scheduleItemDto.getBeginDate().equals("") || scheduleItemDto.getEndDate().equals("")) {
            return true;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = dateFormat.parse(scheduleItemDto.getBeginDate());
            endDate = dateFormat.parse(scheduleItemDto.getEndDate());
        } catch (ParseException e) {
            validatorMessage = "You have wrong format to parse date";
            return false;
        }
        if (beginDate.after(endDate)) {
            return false;
        } else {
            return true;
        }
    }
}
