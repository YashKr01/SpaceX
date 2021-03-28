package com.example.spacex.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "table")
public class User {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("agency")
    private String agency;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("wikipedia")
    private String hyperlink;

    @SerializedName("status")
    private String status;

    public User(String id, String name, String agency, String imageUrl, String hyperlink, String status) {
        this.id = id;
        this.name = name;
        this.agency = agency;
        this.imageUrl = imageUrl;
        this.hyperlink = hyperlink;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", agency='" + agency + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", hyperlink='" + hyperlink + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
