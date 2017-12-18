package com.venky97vp.android.namaste.classes.timetable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by venky on 18-12-2017.
 */

public class TTHour implements Parcelable {
    public String name;
    public String timeInterval;

    public TTHour(String name) {
        this.name = name;
    }

    protected TTHour(Parcel in) {
        name = in.readString();
        timeInterval = in.readString();
    }

    public static final Creator<TTHour> CREATOR = new Creator<TTHour>() {
        @Override
        public TTHour createFromParcel(Parcel in) {
            return new TTHour(in);
        }

        @Override
        public TTHour[] newArray(int size) {
            return new TTHour[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(timeInterval);
    }
}
