package com.karpusha.university.handler;

import com.karpusha.university.exception.AllFacultiesHasNoSizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class FacultyExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public String handleAllFacultiesNullException(AllFacultiesHasNoSizeException exception) {
        return exception.getMessage();
    }
}
