package com.facetrip.restproject.controller;

import com.facetrip.restproject.facebookApi.FaceBookTemplate;
import com.facetrip.restproject.facebookApi.Data.FacebookGraph.FaceBookUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FaceBookRestController {

    @Autowired
    FaceBookTemplate template;

    @RequestMapping("/user/accessToken")
    @ResponseBody
    public String accessToken(@RequestBody String body)
    {
        return body;
    }
    @RequestMapping("/user/login")
    @ResponseBody
    public String testToken(@RequestParam String code){
        return template.getUserSerialiableData(code);
        //return template.getId(code);
    }
    /*
    @RequestMapping(value= "/user/check",method= RequestMethod.POST)
    @ResponseBody
    public String userCheck(@RequestBody AuthResponse data)
    {  System.out.println("Test");
       System.out.println(data);
       return "TEST";
    }
     */
}
