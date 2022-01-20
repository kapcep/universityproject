package com.karpusha.university.exception;

public class StudentGroupIsNullException extends RuntimeException {
    private String errName;
    private String errMessage;

    public StudentGroupIsNullException(String errName, String errMessage) {
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
