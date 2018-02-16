package com.venky97vp.android.namaste.classes;

import java.util.Date;

/**
 * Created by Aswin Nagarajan on 15-02-2018.
 */

public class Assignment {
    private String title;
    private int id;
    private Date deadline;
    private int no_students;
    private Section sec;

    public Assignment(String title, int id,  int no_students, Section sec) {
        this.title = title;
        this.id = id;
        this.no_students = no_students;
        this.sec = sec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getNo_students() {
        return no_students;
    }

    public void setNo_students(int no_students) {
        this.no_students = no_students;
    }

    public Section getSec() {
        return sec;
    }

    public void setSec(Section sec) {
        this.sec = sec;
    }
}
