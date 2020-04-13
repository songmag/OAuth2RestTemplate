package com.facetrip.restproject.kakaoTalk;

import com.facetrip.restproject.kakaoTalk.Data.KakaotalkAccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class KakaoTalkRestTemplate extends RestTemplate {
    private KakaoTalkOAuth2Server server;
    private KakaoTalkClientResource resource;

    @Autowired
    public KakaoTalkRestTemplate(KakaoTalkOAuth2Server server,KakaoTalkClientResource resource)
    {
        this.server = server;
        this.resource = resource;
    }
    public KakaotalkAccessToken getAccessToken(String code)
    {
        ResponseEntity<KakaotalkAccessToken> entity= this.postForEntity(server.getoAuth2ServerUri(),server.getOauth2Entity(resource.getClientId(),resource.getClientSecret(),code), KakaotalkAccessToken.class);
        System.out.println(entity.getBody());
        return entity.getBody();
    }
}
