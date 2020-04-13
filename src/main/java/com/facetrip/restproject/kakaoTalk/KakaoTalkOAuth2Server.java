package com.facetrip.restproject.kakaoTalk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KakaoTalkOAuth2Server {

    @Value("${kakaotalk.access-token}")
    private String oAuth2ServerUri;

    @Value("${kakaotalk.redirect-uri}")
    private String redirectUri;

    @Value("${kakaotalk.grant-type:authorization_code}")
    private String grantType;

    @Value("${kakaotalk.sendform:application/x-www-form-urlencoded;charset=utf-8}")
    private String contentType;

    private HttpHeaders headers=null;
    private Map<String, List<String>> entity=null;

    public String getoAuth2ServerUri() {
        return oAuth2ServerUri;
    }

    public void setoAuth2ServerUri(String oAuth2ServerUri) {
        this.oAuth2ServerUri = oAuth2ServerUri;
    }


    public HttpEntity<Map<String,List<String>>> getOauth2Entity(String clientId, String clientSecret, String code) {
        if(entity == null) {
            entity = new LinkedMultiValueMap<String,String>();
            entity.put("grant_type", Collections.singletonList(grantType));
            entity.put("client_id", Collections.singletonList(clientId));
            entity.put("redirect_uri", Collections.singletonList(redirectUri));
            entity.put("code", Collections.singletonList(code));
            entity.put("client_secret", Collections.singletonList(clientSecret));
        }
        else{
            entity.put("code", Collections.singletonList(code));
        }
        if(headers == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("content-type", contentType);
        }
        HttpEntity<Map<String,List<String>>> httpEntity = new HttpEntity<>(entity, headers);
        return httpEntity;
    }
}
