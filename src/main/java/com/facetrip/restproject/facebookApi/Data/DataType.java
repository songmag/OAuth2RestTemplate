package com.facetrip.restproject.facebookApi.Data;

import java.io.Serializable;

public class DataType<T extends DataObjectType> implements Serializable {
    private T dataObjectType;

    public DataType(T dataObjectType){
        this.dataObjectType = dataObjectType;
    }

    public T getDataObjectType(){
        return dataObjectType;
    }
    public void setDataObjectType(T dataObjectType){
        this.dataObjectType = dataObjectType;
    }
    public void setData(String data)
    {
        this.dataObjectType.setData(data);
    }
    public void setData(T dataObjectType) {
        this.dataObjectType.setData(dataObjectType);
    }
    public String getSeiralizableData()
    {
        return this.dataObjectType.getSerializedData();
    }
}
