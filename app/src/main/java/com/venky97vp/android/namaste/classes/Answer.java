package com.venky97vp.android.namaste.classes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by venky on 23-09-2017.
 */

public class Answer implements Parcelable {
    public String id;
    public String answerText;
    public String expert;

    public Answer() {
    }

    public Answer(String id, String answerText, String expert) {
        this.id = id;
        this.answerText = answerText;
        this.expert = expert;
    }

    private Answer(Parcel in) {
        this.id = in.readString();
        this.answerText = in.readString();
        this.expert = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(answerText);
        dest.writeString(expert);
    }

    public static final Parcelable.Creator<Answer> CREATOR = new Parcelable.Creator<Answer>() {

        @Override
        public Answer createFromParcel(Parcel source) {
            return new Answer(source);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };
}
