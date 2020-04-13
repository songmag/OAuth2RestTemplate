package com.facetrip.restproject.facebookApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class FaceBookResourcesServer {
    @Value("${facebook.server-url}")
    private String defaultUri;
    @Value("${facebook.handler-version}")
    private String handlerVersion = "v6.0";
    @Value("${facebook.resources-rest}")
    private String resourcesRest = "me";

    @Autowired
    @Qualifier("defaultRequestResource")
    private RequestResource requestResource;

    private String tempUri=null;

    public String getResources(RequestResource resource, String token) {
        StringBuilder builder;
        if(tempUri == null){
            builder = new StringBuilder(defaultUri);
            builder.append("/").append(handlerVersion).append("/").append(resourcesRest).append("?");
            tempUri=builder.toString();
        }
        else{
            builder=  new StringBuilder(tempUri);
        }
        if(!requestResource.equals(resource) && resource != null)
        {
            builder.append(resource.toString());
        }
        else{
            builder.append(requestResource.toString());
        }
        builder.append("&access_token=");
        builder.append(token);
        return builder.toString();
    }
}
