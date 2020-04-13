package com.facetrip.restproject.facebookApi;

import com.facetrip.restproject.facebookApi.Data.*;
import com.facetrip.restproject.facebookApi.Data.FacebookGraph.FaceBookUser;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class FaceBookTemplate extends RestTemplate {
    private FaceBookResourcesServer resourcesServer;
    private FaceBookOAuth2Server oAuth2Server;
    private FaceBookClientResource resource;

    @Autowired
    @Qualifier("requestResourceId")
    private RequestResource idRequest;

    @Autowired
    Gson gson;

    @Autowired
    public FaceBookTemplate(FaceBookOAuth2Server oAuth2Server,
                            FaceBookResourcesServer resourcesServer,
                            FaceBookClientResource resource)
    {
        this.oAuth2Server =oAuth2Server;
        this.resourcesServer=resourcesServer;
        this.resource = resource;
    }
    public FaceBookUser getUserObject(String code)
    {
        FaceBookAccessToken accessToken = getAccessToken(code);
        FaceBookUser user = (FaceBookUser) getUserInfo(accessToken.getAccess_token()).getDataObjectType().getData();
        user.setAccessToken(accessToken.getAccess_token());
        return user;
    }
    public DataTransObject getUser(String code){
        return getUserInfo(getAccessToken(code).getAccess_token()).getDataObjectType().getData();
    }
    public String getUserSerialiableData(String code)
    {
        return getUserInfo(getAccessToken(code).getAccess_token()).getSeiralizableData();
    }
    public DataObjectType getUserDataObject(String code)
    {
        return getUserInfo(getAccessToken(code).getAccess_token()).getDataObjectType();
    }
    public String getId(String code)
    {
        return getUserId(getAccessToken(code).getAccess_token());
    }
    protected String getUserId(String accessToken)
    {
        Map<String,String> id = getForObject(resourcesServer.getResources(idRequest,accessToken), Map.class);
        return (String) id.get("id");
    }
    protected DataType getUserInfo(String accessToken){
        if(resourcesServer == null) throw new NullPointerException();
        String t=this.getForObject(resourcesServer.getResources(null,accessToken),String.class);
        DataType<DataObjectType<DataTransObject>> dataType = new DataType<DataObjectType<DataTransObject>>(new JsonData<FaceBookUser>(FaceBookUser.class,gson));
        dataType.setData(t);
        return dataType;
    }
    protected FaceBookAccessToken getAccessToken(String code){
        if(oAuth2Server == null || resource == null) throw new NullPointerException();
        String uri = oAuth2Server.getUri(resource.getClientId(),resource.getClientSecret(),code);
        FaceBookAccessToken token = this.getForObject(uri,FaceBookAccessToken.class);
        return token;
    }
}
