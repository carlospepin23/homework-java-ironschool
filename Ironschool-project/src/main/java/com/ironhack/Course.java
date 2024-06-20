package com.ironhack;

import java.util.UUID;

public class Course {

    //properties
    private String courseId;
    private String name;
    private double price;
    private double money_earned;
//    private Teacher teacher;

    //constructor
    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.money_earned = 0;
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

    public void setMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(double teacher) {
//        this.teacher = teacher;
//    }

    //add to_string method when the teacher class is completed

}
