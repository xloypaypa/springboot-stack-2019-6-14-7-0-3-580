package com.tw.apistackbase.employee.entity;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private int age;
    private Gender gender;

    public Employee() {
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                age == employee.age &&
                Objects.equals(name, employee.name) &&
                gender == employee.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender);
    }
}
