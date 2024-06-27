package com.ironhack;

import java.util.UUID;

public class Course {

    //properties
    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    //constructor
    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString().substring(0, 4);
        this.name = name;
        this.price = price;
        this.money_earned = 0;
        this.teacher = null;
    }

    //getters and setters

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void setMoney_earned() {
        this.money_earned=this.getPrice()-this.getTeacher().getSalary();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", money_earned=" + money_earned +
                ", teacher=" + teacher +
                '}';
    }
}

