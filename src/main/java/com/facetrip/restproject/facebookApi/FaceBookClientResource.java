package com.facetrip.restproject.facebookApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class FaceBookClientResource {

    @Value("${facebook.client-id}")
    private String clientId;

    @Value("${facebook.client-secret}")
    private String clientSecret;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
