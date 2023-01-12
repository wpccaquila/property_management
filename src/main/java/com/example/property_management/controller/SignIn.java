package com.example.property_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignIn {
    @RequestMapping("/myjsp")
    public String index(HttpServletRequest request){
        request.setAttribute("data","wpc使用SpringBoot");
        return "index";
    }
}
