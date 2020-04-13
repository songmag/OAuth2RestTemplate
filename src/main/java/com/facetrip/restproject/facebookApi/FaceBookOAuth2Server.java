package com.facetrip.restproject.facebookApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class FaceBookOAuth2Server {

    @Value("${facebook.access-token:/oauth/access_token}")
    private String oAuth2ServerUri;
    @Value("${facebook.handler-version}")
    private String version;
    @Value("${facebook.server-url}")
    private String hostServer;

    private String fullOauth2ServerUri=null;

    @Value("${facebook.redirect-uri:http://localhost:8080/user/login}")
    private String redirectUri;


    public String getUri(String clientId, String clientSecret, String code) {
        StringBuilder builder = null;
        if(fullOauth2ServerUri == null)
        {
            builder = new StringBuilder(hostServer);
            builder.append("/").append(version).append(oAuth2ServerUri);
            builder.append("?").append("client_id=").append(clientId)
                    .append("&redirect_uri=").append(redirectUri).append("&client_secret=")
                    .append(clientSecret).append("&code=");
            fullOauth2ServerUri = builder.toString();
        }
        else
        {
            builder = new StringBuilder(fullOauth2ServerUri);
        }
        builder.append(code);
        return builder.toString();
    }
}
