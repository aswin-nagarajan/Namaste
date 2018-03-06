package com.venky97vp.android.namaste.classes;

import java.util.Date;

/**
 * Created by venky on 26-08-2017.
 */

public class Presence {
    private boolean isPresent;
    private boolean isAbsent;
    private String id;
    private String Name;

    public Presence(Student st) {
        id = st.uid;
        Name = st.Name;
        isPresent = false;
        isPresent = true;

    }

    public Presence(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Presence(boolean isP, boolean isA, String id, String name){
        this.isPresent=isP;
        this.isAbsent=isA;
        this.id=id;
        this.Name = name;
    }
    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean absent) {
        isAbsent = absent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPresent() {

        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
