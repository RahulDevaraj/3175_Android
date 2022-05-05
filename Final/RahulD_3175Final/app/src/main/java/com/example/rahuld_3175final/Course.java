package com.example.rahuld_3175final;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Course {
    LocalDate courseDate;
    String courseName;
    int courseDrawable;
    Double coursePrice;
    int courseDiscount;
    int numberOfSessions;

    public double sumTotal(){
        double total = 0.0;

        total = coursePrice * numberOfSessions;

        if(courseDiscount == 1)
            total = total - .1*total;

        return total;

    }

    public Course(LocalDate courseDate, String courseName, int courseDrawable, Double coursePrice, int courseDiscount, int numberOfSessions) {
        this.courseDate = courseDate;
        this.courseName = courseName;
        this.courseDrawable = courseDrawable;
        this.coursePrice = coursePrice;
        this.courseDiscount = courseDiscount;
        this.numberOfSessions = numberOfSessions;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Course(String courseName, int courseDrawable, Double coursePrice, int courseDiscount, int numberOfSessions) {

        this.courseName = courseName;
        this.courseDrawable = courseDrawable;
        this.coursePrice = coursePrice;
        this.courseDiscount = courseDiscount;
        this.numberOfSessions = numberOfSessions;
        courseDate = LocalDate.now();
    }

    public LocalDate getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(LocalDate courseDate) {
        this.courseDate = courseDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseDrawable() {
        return courseDrawable;
    }

    public void setCourseDrawable(int courseDrawable) {
        this.courseDrawable = courseDrawable;
    }

    public Double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public int getCourseDiscount() {
        return courseDiscount;
    }

    public void setCourseDiscount(int courseDiscount) {
        this.courseDiscount = courseDiscount;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }

    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }
}
