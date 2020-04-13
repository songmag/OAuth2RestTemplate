package com.facetrip.restproject.facebookApi.Data.FacebookGraph;

public class FaceBookLocation {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FaceBookLocation{" +
                "name='" + name + '\'' +
                '}';
    }
}
