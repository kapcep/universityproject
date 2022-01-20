package com.karpusha.university.handler;

import com.karpusha.university.exception.StudentIsNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler(StudentIsNullException.class)
    public ModelAndView handleStudentIsNullException(StudentIsNullException exception) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errMessage", exception.getErrMessage());
        mav.addObject("errName", exception.getErrName());
        return mav;
    }
}
