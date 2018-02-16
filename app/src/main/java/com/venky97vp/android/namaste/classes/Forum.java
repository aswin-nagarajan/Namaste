package com.venky97vp.android.namaste.classes;

import java.util.ArrayList;

/**
 * Created by venky on 06-09-2017.
 */

public class Forum {
    public String id;
    public String category;
    public String question;
    public String questionExtended;
    public boolean answered;
    public ArrayList<Answer> answer;
    public String uploader;
    public ArrayList<String> photoLinks;
    public ArrayList<String> fileLinks;
}
