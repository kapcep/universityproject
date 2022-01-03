package com.karpusha.university.dto;

public class DatePickerDto {
    private String chosenDate;

    public DatePickerDto() {
    }

    public DatePickerDto(String chosenDate) {
        this.chosenDate = chosenDate;
    }

    public String getChosenDate() {
        return chosenDate;
    }

    public void setChosenDate(String chosenDate) {
        this.chosenDate = chosenDate;
    }
}
