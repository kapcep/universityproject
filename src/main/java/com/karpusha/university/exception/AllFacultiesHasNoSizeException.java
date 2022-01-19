package com.karpusha.university.exception;

public class AllFacultiesHasNoSizeException extends RuntimeException {
    private String message;


    public AllFacultiesHasNoSizeException(String message) {
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
