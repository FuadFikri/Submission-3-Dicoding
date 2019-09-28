package com.fikri.moviecatalogue3.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class Movie implements Parcelable {
    private String title;
    private String language;
    private Double vote_average;
    private String overview;
    private String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    public Movie(JSONObject object) {
        try {
            String title = object.getString("title");
            Double vote_average = object.getDouble("vote_average");
            String language= object.getString("original_language");
            String overview = object.getString("overview");
            String poster = object.getString("poster_path");

            this.title = title;
            this.vote_average = vote_average;
            this.language= language;
            this.overview = overview;
            this.poster = poster;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.language);
        dest.writeValue(this.vote_average);
        dest.writeString(this.overview);
        dest.writeString(this.poster);
    }

    protected Movie(Parcel in) {
        this.title = in.readString();
        this.language = in.readString();
        this.vote_average = (Double) in.readValue(Double.class.getClassLoader());
        this.overview = in.readString();
        this.poster = in.readString();
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
