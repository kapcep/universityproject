package com.karpusha.university.handler;

import com.karpusha.university.exception.StudentGroupIsNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class StudentGroupHandler {
    @ExceptionHandler(StudentGroupIsNullException.class)
    public ModelAndView handleFacultyIsNullException(StudentGroupIsNullException exception) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errMessage", exception.getErrMessage());
        mav.addObject("errName", exception.getErrName());
        return mav;
    }

}
