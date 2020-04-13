package com.facetrip.restproject.controller;

import com.facetrip.restproject.kakaoTalk.KakaoTalkRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class KakaotalkRestController {

    @Autowired
    KakaoTalkRestTemplate template;

    @RequestMapping("/kakaologin")
    @ResponseBody
    public String getLogin(@RequestParam String code){
        return template.getAccessToken(code).toString();
    }
}
