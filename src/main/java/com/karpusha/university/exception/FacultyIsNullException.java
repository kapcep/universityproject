package com.karpusha.university.exception;

public class FacultyIsNullException extends RuntimeException {
    private String errName;
    private String errMessage;

    public FacultyIsNullException(String errName, String errMessage) {
        this.errMessage = errMessage;
        this.errName = errName;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }
}
