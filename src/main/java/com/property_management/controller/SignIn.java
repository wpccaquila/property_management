package com.property_management.controller;

import com.property_management.pojo.OwnerInfo;
import com.property_management.service.OwnerInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SignIn {
    @Resource
    OwnerInfoService ownerInfoService;



    @RequestMapping("/sign_in")
    public String index(int owner_id, HttpServletRequest request){
        System.out.println("——————成功跳转到首页——————");


        System.out.println("——————通过姓名查询业主信息——————");
        OwnerInfo ownerInfo = ownerInfoService.queryOwnerById(owner_id);
        System.out.println(ownerInfo);
        request.setAttribute("ownerInfo",ownerInfo);

        return "forward:index.jsp";
    }

}
