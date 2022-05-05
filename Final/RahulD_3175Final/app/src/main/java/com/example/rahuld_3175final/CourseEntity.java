package com.example.rahuld_3175final;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "courses")
public class CourseEntity {
    @PrimaryKey
    @ColumnInfo(name = "coursename")
    @NonNull
    String coursename;
    @ColumnInfo(name = "coursedate")
    String coursedate;
    @ColumnInfo(name = "coursepic")
    @NonNull
    int coursepic;
    @ColumnInfo(name = "courseprice")
    @NonNull
    double courseprice;
    @ColumnInfo(name = "coursenumsessions")
    @NonNull
    int coursenumsessions;
    @ColumnInfo(name = "coursediscount")
    @NonNull
    int coursediscount;

    public CourseEntity(@NonNull String coursename, String coursedate, int coursepic, double courseprice, int coursenumsessions, int coursediscount) {
        this.coursename = coursename;
        this.coursedate = coursedate;
        this.coursepic = coursepic;
        this.courseprice = courseprice;
        this.coursenumsessions = coursenumsessions;
        this.coursediscount = coursediscount;
    }

    public CourseEntity() {
    }

    @NonNull
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(@NonNull String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedate() {
        return coursedate;
    }

    public void setCoursedate(String coursedate) {
        this.coursedate = coursedate;
    }

    public int getCoursepic() {
        return coursepic;
    }

    public void setCoursepic(int coursepic) {
        this.coursepic = coursepic;
    }

    public double getCourseprice() {
        return courseprice;
    }

    public void setCourseprice(double courseprice) {
        this.courseprice = courseprice;
    }

    public int getCoursenumsessions() {
        return coursenumsessions;
    }

    public void setCoursenumsessions(int coursenumsessions) {
        this.coursenumsessions = coursenumsessions;
    }

    public int getCoursediscount() {
        return coursediscount;
    }

    public void setCoursediscount(int coursediscount) {
        this.coursediscount = coursediscount;
    }
}
