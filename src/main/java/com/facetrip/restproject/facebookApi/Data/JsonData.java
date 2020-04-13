package com.facetrip.restproject.facebookApi.Data;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonData<T extends DataTransObject> extends DataObjectType {
    private String typeData;
    private Gson gson;
    public JsonData(Class typeClass, Gson gson) {
        super(typeClass);
        this.gson = gson;
    }

    @Override
    public DataTransObject getData() {
        return typeObject;
    }
    @Override
    public String getSerializedData() {
        return this.typeData;
    }
    @Override
    public boolean setData(DataObjectType data) {
        if(!(((JsonData) data).typeClass != this.typeClass)) return false;
        this.typeClass =  data.typeClass;
        setData(data.planeData);
        return true;
    }

    @Override
    public boolean setData(String data) {
        this.planeData = data;
        typeObject = (DataTransObject) gson.fromJson(data,typeClass);
        typeData = gson.toJson(typeObject);
        if(typeObject == null) return false;
        return true;
    }
}
