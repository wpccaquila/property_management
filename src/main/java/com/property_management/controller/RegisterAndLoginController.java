package com.property_management.controller;

import com.property_management.pojo.OwnerInfo;
import com.property_management.service.common.OwnerInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
        return "/register.jsp";
    }




    /**
     * 注册业主账号
     * @return
     */
    @RequestMapping("/register")
    @Transactional
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
        return "/index.jsp";
    }

    /**
     * 验证数据库后登录
     * @param owner_phone
     * @param owner_password
     * @return
     */
    @RequestMapping("/owner_login")
    public String login(int owner_phone,String owner_password, String role) {
        // 登录身份为管理员
        if (role.equals("admin") && owner_phone == 123456 && owner_password.equalsIgnoreCase("admin")) {
            return "manager/manager_home_page";
        }
        // 登录身份为住户
        else if (role.equals("resident")) {
            // 数据库验证
            OwnerInfo currentOwnerInfo = ownerInfoService.queryOwnerByPhoneAndPassword(owner_phone, owner_password);
            System.out.println(currentOwnerInfo);
            // 密码或用户错误提示

            // 跳转到用户主页面
        }
        return "/index.jsp";
    }


}
