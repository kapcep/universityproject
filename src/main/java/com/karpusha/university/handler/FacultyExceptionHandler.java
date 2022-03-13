package com.karpusha.university.handler;

import com.karpusha.university.exception.FacultyIsNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class FacultyExceptionHandler {

//    @ExceptionHandler(FacultyIsNullException.class)
//    public ModelAndView handleFacultyIsNullException(FacultyIsNullException exception) {
//        ModelAndView mav = new ModelAndView("error");
//        mav.addObject("errMessage", exception.getErrMessage());
//        mav.addObject("errName", exception.getErrName());
//        return mav;
//    }
}
