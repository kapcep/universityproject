package com.karpusha.university.exception;

public class AllFacultiesNullException extends RuntimeException {
    private String message;


    public AllFacultiesNullException(String message) {
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
