package com.example.assigment3;

import android.os.Parcel;
import android.os.Parcelable;

public class Response implements Parcelable {
    private String name;
    private String email;
    private String role;

    public Response(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    protected Response(Parcel in) {
        name = in.readString();
        email = in.readString();
        role = in.readString();
    }

    public static final Creator<Response> CREATOR = new Creator<Response>() {
        @Override
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        @Override
        public Response[] newArray(int size) {
            return new Response[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(role);
    }
}
