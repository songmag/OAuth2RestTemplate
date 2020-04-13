package com.facetrip.restproject.kakaoTalk;
import org.springframework.beans.factory.annotation.Value;
public class KakaoTalkClientResource {
    @Value("${kakaotalk.client-id}")
    private String clientId;
    @Value("${kakaotalk.client-secret}")
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
