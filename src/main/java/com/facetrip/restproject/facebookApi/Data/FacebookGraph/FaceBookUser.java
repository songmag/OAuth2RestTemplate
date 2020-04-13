package com.facetrip.restproject.facebookApi.Data.FacebookGraph;


import com.facetrip.restproject.facebookApi.Data.DataTransObject;

public class FaceBookUser implements DataTransObject {
    private String email;
    private String name;
    private String id;
    private FaceBookPicture picture;
    private FaceBookHomeTown hometown;
    private FaceBookLocation location;
    private String birthday;
    private String gender;
    private String accessToken;
    public FaceBookHomeTown getHometown() {
        return hometown;
    }
    public void setHometown(FaceBookHomeTown hometown) {
        this.hometown = hometown;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public FaceBookPicture getPicture() {
        return picture;
    }
    public void setPicture(FaceBookPicture picture) {
        this.picture = picture;
    }
    public FaceBookLocation getLocation() {
        return location;
    }
    public void setLocation(FaceBookLocation location) {
        this.location = location;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "FaceBookUser{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", picture=" + picture.toString() +
                ", homeTown=" + hometown.toString() +
                ", location=" + location.toString() +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
    @Override
    public String getSerializableString() {
        return toString();
    }
}
