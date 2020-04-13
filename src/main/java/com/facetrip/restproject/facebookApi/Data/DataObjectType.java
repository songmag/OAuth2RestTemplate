package com.facetrip.restproject.facebookApi.Data;

import java.io.Serializable;

public abstract class DataObjectType<T extends DataTransObject> implements Serializable {
    protected Class<T> typeClass;
    protected T typeObject;
    protected String planeData;

    public DataObjectType(Class<T> typeClass) {
        this.typeClass = typeClass;
    }
    abstract public DataTransObject getData();
    abstract public String getSerializedData();
    abstract public boolean setData(DataObjectType data);
    abstract public boolean setData(String data);
}
