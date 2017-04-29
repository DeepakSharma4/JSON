package com.example.hp.json;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hp on 4/13/2017.
 */

public class model implements Parcelable {
    private int id;
    private String name;
    private int salary;
//constructer

    public model(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
// getter funcation

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    //overide methods of Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    protected model(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.salary = in.readInt();

    }

    public static final Creator<model> CREATOR = new Creator<model>() {
        @Override
        public model createFromParcel(Parcel in) {
            return new model(in);
        }

        @Override
        public model[] newArray(int size) {
            return new model[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(salary);
    }

    //


    //

}
