package com.mateuszkoslacz.moviper.rxsample.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jjodelka on 17/10/16.
 */

public class User {
    @SerializedName("organizations_url")
    private String organizationsUrl;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("gists_url")
    private String gistsUrl;
    @SerializedName("html_url")
    private String htmlUrl;
    private String type;
    private String url;
    private String id;
    private String login;

    public User() {}

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

    @Override
    public String toString() {
        return "User{" +
                "organizationsUrl='" + organizationsUrl + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gistsUrl='" + gistsUrl + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
