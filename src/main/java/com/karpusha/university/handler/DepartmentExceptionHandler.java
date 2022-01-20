package com.karpusha.university.handler;

import com.karpusha.university.exception.DepartmentIsNullException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DepartmentExceptionHandler {
    @ExceptionHandler(DepartmentIsNullException.class)
    public ModelAndView handleDepartmentIsNullException(DepartmentIsNullException exception) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("errMessage", exception.getErrMessage());
        mav.addObject("errName", exception.getErrName());
        return mav;
    }
}
