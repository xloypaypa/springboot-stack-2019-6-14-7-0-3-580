package com.tw.apistackbase.entity;

public class Employee {

    private final int id;
    private final String name;
    private final int age;
    private final Gender gender;

    public Employee(int id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
