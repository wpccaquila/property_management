package com.property_management.controller;

import com.property_management.pojo.OwnerInfo;
import com.property_management.service.common.OwnerInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录与注册功能控制类
 */
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
    public String register(String owner_name, int owner_phone, String owner_password,
                           String owner_address, String owner_identity, HttpServletRequest request){
        System.out.println("————调用register方法————");
        OwnerInfo ownerInfo = new OwnerInfo(owner_name,owner_phone,owner_address,owner_password,owner_identity);
        // 设置到域中，方便数据回填
        request.setAttribute("ownerInfo",ownerInfo);
        System.out.println(ownerInfo);

        // 添加新用户
        int num = ownerInfoService.addOwner(ownerInfo);

        if(num == 1){
            System.out.println("————注册成功————");
            return "forward:/index.jsp";
        }
        return "forward:/register.jsp";
    }

    /**
     * 验证数据库后登录
     * @param owner_phone
     * @param owner_password
     * @return
     */
    @RequestMapping("/owner_login")
    public String login(int owner_phone,String owner_password, String role,HttpServletRequest request) {
        // 登录身份为管理员
        if (role.equals("admin") && owner_phone == 123456 && owner_password.equalsIgnoreCase("admin")) {
            return "manager/manager_home_page";
        }else if(role.equals("admin") && owner_phone != 123456 && !owner_password.equalsIgnoreCase("admin")){
            //管理员密码或账户输入错误
            request.setAttribute("login_msg","用户名或密码错误");
            return "forward:/index.jsp";
        }
        // 登录身份为住户
        if (role.equals("resident")) {
            // 数据库验证
            OwnerInfo currentOwnerInfo = ownerInfoService.queryOwnerByPhoneAndPassword(owner_phone, owner_password);
            System.out.println(currentOwnerInfo);
            // 密码或用户错误提示
            //  若是没有找到信息，则currentOwnerInfo为null
            if(currentOwnerInfo == null){
                System.out.println("用户名或密码错误");
                request.setAttribute("login_msg","用户名或密码错误");
                return "forward:/index.jsp";
            }else {
                // 跳转到用户主页面
            }
        }
        return "forward:/index.jsp";
    }


}
