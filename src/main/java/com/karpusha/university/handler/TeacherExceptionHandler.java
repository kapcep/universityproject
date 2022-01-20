package com.karpusha.university.handler;

import com.karpusha.university.exception.TeacherIsNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class TeacherExceptionHandler {
    @ExceptionHandler(TeacherIsNullException.class)
    public ModelAndView handleTeacherIsNullException(TeacherIsNullException exception) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errMessage", exception.getErrMessage());
        mav.addObject("errName", exception.getErrName());
        return mav;
    }
}
