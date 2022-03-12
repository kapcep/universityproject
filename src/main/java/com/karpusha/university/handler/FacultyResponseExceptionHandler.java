package com.karpusha.university.handler;

import com.karpusha.university.exception.FacultyIncorrectData;
import com.karpusha.university.exception.FacultyIsNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FacultyResponseExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<FacultyIncorrectData> handleFacultyException(FacultyIsNullException exception) {
        FacultyIncorrectData data = new FacultyIncorrectData();
        data.setInfo(exception.getErrMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<FacultyIncorrectData> handleFacultyException(Exception exception) {
        FacultyIncorrectData data = new FacultyIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
