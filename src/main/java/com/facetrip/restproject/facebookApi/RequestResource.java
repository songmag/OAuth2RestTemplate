package com.facetrip.restproject.facebookApi;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;
public class RequestResource {

    @Value("${facebook.request-field}")
    private String[] fields;

    public RequestResource() {
    }

    public RequestResource(String... field) {
        this.fields = field;
    }

    public String[] getField() {
        return fields;
    }

    public void setField(String[] field) {
        this.fields = field;
    }

    @Override
    public String toString() {
        return "fields=" + Arrays.toString(fields).replace("[","").replace("]","").replaceAll(" ","");
    }
}
