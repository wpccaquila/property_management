package com.property_management.controller;

import com.property_management.pojo.OwnerInfo;
import com.property_management.service.common.OwnerInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class RegisterAndLoginController {
    @Resource
    OwnerInfoService ownerInfoService;

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/register_forward")
    public String register_forward(){
        return "register";
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/index_forward")
    public String index_forward(){
        return "redirect:index.jsp";
    }


    /**
     * 注册业主账号
     * @return
     */
    @RequestMapping("/register")
    public String register(String owner_name,int owner_phone,String owner_password,
                           String owner_address, String owner_identity){
        System.out.println("————调用register方法————");
        OwnerInfo ownerInfo = new OwnerInfo(owner_name,owner_phone,owner_address,owner_password,owner_identity);
        System.out.println(ownerInfo);
        int num = ownerInfoService.addOwner(ownerInfo);
        if(num == 1){
            System.out.println("————注册成功————");
        }else {
            System.out.println("————注册出问题————，返回值为：" + num);
        }
        return "redirect:index.jsp";
    }

    /**
     * 验证数据库后登录
     * @param owner_phone
     * @param owner_password
     * @return
     */
    @RequestMapping("/owner_login")
    public String login(int owner_phone,String owner_password){
        OwnerInfo currentOwnerInfo = ownerInfoService.queryOwnerByPhoneAndPassword(owner_phone, owner_password);
        System.out.println(currentOwnerInfo);
        return "redirect:index.jsp";
    }




}
