package com.example.submisi1made;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int banner;
    private String name;
    private String description;
    private String release;
    private String categoty;
    private String director;

    Movie() {
    }



    int getBanner() {
        return banner;
    }

    void setBanner(int banner) {
        this.banner = banner;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getRelease() {
        return release;
    }

    void setRelease(String release) {
        this.release = release;
    }

    String getCategoty() {
        return categoty;
    }

    void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    String getDirector() {
        return director;
    }

    void setDirector(String director) {
        this.director = director;
    }


    private Movie(Parcel in) {
        this.banner = in.readInt();
        this.name = in.readString();
        this.release = in.readString();
        this.categoty = in.readString();
        this.director = in.readString();
        this.description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.banner);
        dest.writeString(this.name);
        dest.writeString(this.release);
        dest.writeString(this.categoty);
        dest.writeString(this.director);
        dest.writeString(this.description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
