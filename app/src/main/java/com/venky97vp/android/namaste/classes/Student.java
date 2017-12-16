package com.venky97vp.android.namaste.classes;

/**
 * Created by venky on 26-08-2017.
 */

public class Student {
    public String uid;
    public String name;
    public long registerNumber;
    public String address;
    public double grade;
    public String section;
    public String fatherName;
    public String fatherContact;
    public GradeSheet gradeSheet;

    public Student(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }
}
