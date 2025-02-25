package com.tw.apistackbase.employee.entity;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
