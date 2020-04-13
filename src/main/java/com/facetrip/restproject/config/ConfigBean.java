package com.facetrip.restproject.config;

import com.facetrip.restproject.facebookApi.*;
import com.facetrip.restproject.kakaoTalk.KakaoTalkClientResource;
import com.facetrip.restproject.kakaoTalk.KakaoTalkOAuth2Server;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Bean
    public RequestResource defaultRequestResource(){
        return new RequestResource();
    }
    @Bean
    public RequestResource requestResourceId(){
        return new RequestResource("id");
    }
    @Bean
    public FaceBookOAuth2Server oAuth2Server(){return new FaceBookOAuth2Server();}
    @Bean
    public FaceBookResourcesServer faceBookResourcesServer(){return new FaceBookResourcesServer();}
    @Bean
    public FaceBookClientResource faceBookClientResource(){return new FaceBookClientResource();}
    @Bean
    public KakaoTalkClientResource kakaoTalkClientResource(){return new KakaoTalkClientResource();}
    @Bean
    public Gson gson(){
        return new Gson();
    }
    @Bean
    public KakaoTalkOAuth2Server kakaoTalkOAuth2Server(){return new KakaoTalkOAuth2Server();}
}
