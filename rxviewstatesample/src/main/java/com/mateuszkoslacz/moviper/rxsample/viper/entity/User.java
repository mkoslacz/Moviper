package com.mateuszkoslacz.moviper.rxsample.viper.entity;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jjodelka on 17/10/16.
 */

public class User implements Parcelable {

    @SerializedName("organizations_url")
    private String organizationsUrl;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("gists_url")
    private String gistsUrl;
    @SerializedName("html_url")
    private String htmlUrl;
    private String location;
    private String company;
    private String email;
    private String name;
    private String blog;
    private String type;
    private String url;
    private String id;
    private String login;

    public User() {
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.organizationsUrl);
        dest.writeString(this.avatarUrl);
        dest.writeString(this.gistsUrl);
        dest.writeString(this.htmlUrl);
        dest.writeString(this.location);
        dest.writeString(this.company);
        dest.writeString(this.email);
        dest.writeString(this.name);
        dest.writeString(this.blog);
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeString(this.id);
        dest.writeString(this.login);
    }

    protected User(Parcel in) {
        this.organizationsUrl = in.readString();
        this.avatarUrl = in.readString();
        this.gistsUrl = in.readString();
        this.htmlUrl = in.readString();
        this.location = in.readString();
        this.company = in.readString();
        this.email = in.readString();
        this.name = in.readString();
        this.blog = in.readString();
        this.type = in.readString();
        this.url = in.readString();
        this.id = in.readString();
        this.login = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
