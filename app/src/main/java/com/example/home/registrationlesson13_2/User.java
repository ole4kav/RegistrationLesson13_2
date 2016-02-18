package com.example.home.registrationlesson13_2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HOME on 08/02/2016.
 */
public class User implements Parcelable
{
    String name;
    String last;
    String phone;
    String address;
    int idnum;
    String email;
    String password;

    public User(String name, String last, String phone, String address, int idnum, String email, String password){
        this.name = name;
        this.last = last;
        this.phone = phone;
        this.address = address;
        this.idnum = idnum;
        this.email = email;
        this.password = password;
    }

    public User(String name, String last, String phone, String address, int idnum, String email) {
        this(name, last, phone, address, idnum, email,"");
    }

    public User(String name, String last){
        this.name = name;
        this.last = last;
    }

    public User() {}

    @Override
    public String toString() {
        return "First name: " +name+ "\nLast name:" +last;
    }

    @Override
    public boolean equals(Object o) {  //if new user != old users - return false
        if (o instanceof User) {
            User checkUser = (User) o;

            if ((this.name.equals(checkUser.name)) && (this.last.equals(checkUser.last)) && (this.phone.equals(checkUser.phone))
                    && (this.address.equals(checkUser.address)) && (this.idnum == checkUser.idnum) && (this.email.equals(checkUser.email))
                    && (this.password.equals(checkUser.password))) {
                return true;
            }
        }
        return false;
    }

    protected User(Parcel in) {
        name = in.readString();
        last = in.readString();
        phone = in.readString();
        address = in.readString();
        idnum = in.readInt();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>()
    {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(last);
        dest.writeString(phone);
        dest.writeString(address);
        dest.writeInt(idnum);
        dest.writeString(email);
        dest.writeString(password);
    }
}

