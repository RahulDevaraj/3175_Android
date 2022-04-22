package com.example.finalprep2;

import java.time.LocalDate;

public class Dog {
    int id;
    int dogPic;
    String dogBreed;
    String dogName;
    LocalDate dob;

    public Dog(int id, int dogPic, String dogBreed, String dogName, LocalDate dob) {
        this.id = id;
        this.dogPic = dogPic;
        this.dogBreed = dogBreed;
        this.dogName = dogName;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDogPic() {
        return dogPic;
    }

    public void setDogPic(int dogPic) {
        this.dogPic = dogPic;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
