package com.property_management.controller.manager;


import com.github.pagehelper.PageInfo;
import com.property_management.pojo.OwnerInfo;
import com.property_management.service.common.OwnerInfoService;
import com.property_management.service.manager.page.ManagerOwnerInformationPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 管理员页面——用户信息管理控制器
 */
@Controller
public class ManagerOwnerInformationController {
    // 分页时，每次返回多少条数据
    int PAGESIZE = 4;
    // 默认返回第一页
    int PAGEDEFAULT = 1;

    @Resource
    ManagerOwnerInformationPageService managerOwnerInformationPageService;
    @Resource
    OwnerInfoService ownerInfoService;

    /**
     * 修改用户信息
     * @param ownerId
     * @param request
     * @return
     */
    @RequestMapping("/forwardUpdateOwner")
    public String forwardUpdateOwner(int ownerId,HttpServletRequest request){
        // 通过id查询用户，并返回信息
        OwnerInfo ownerInfoById = ownerInfoService.queryOwnerById(ownerId);
        request.setAttribute("ownerInfoById",ownerInfoById);
        return "manager/manager_owner_information/manager_owner_information_update_page";
    }

    /**
     * 请求数据
     * @param request
     * @return
     */
//    @GetMapping("/page_manager_owner_information")
//    public String pageManagerOwnerInformation(HttpServletRequest request){
//        // 如果没有请求页码参数时，默认请求第一页的数据
//        List<OwnerInfo> ownerInfoList = managerOwnerInformationPageService.getOwnerInfoList(1, PAGESIZE);
//        request.setAttribute("ownerInfoList",ownerInfoList);
//        return "manager/manager_owner_information/manager_owner_information_page";
//    }

    @RequestMapping("/page_manager_owner_information")
    public String pageManagerOwnerInformation(HttpServletRequest request,int pageNo){
        System.out.println("——————33333——————");
        List<OwnerInfo> ownerInfoByPageList = managerOwnerInformationPageService.getOwnerInfoByPage(pageNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<OwnerInfo> pageInfo = new PageInfo<>(ownerInfoByPageList);
        System.out.println("——————22222——————");
        // 将pageInfo保存到域中

        System.out.println("ownerInfoList:----" + ownerInfoByPageList);

        request.setAttribute("ownerInfoList",ownerInfoByPageList);
        request.setAttribute("ownerInfoPageInfo",pageInfo);
        System.out.println("——————11111——————");
        return "manager/manager_owner_information/manager_owner_information_page";
    }

    /**
     * 通过查询id返回数据
     * @param request
     * @return
     */
    @RequestMapping("/selectOwnerInfoById")
    public String selectOwnerInfoById(HttpServletRequest request,int ownerId){
        OwnerInfo ownerInfoById = ownerInfoService.queryOwnerById(ownerId);
        request.setAttribute("ownerInfoById",ownerInfoById);
        return pageManagerOwnerInformation(request,PAGEDEFAULT);
    }

    /**
     * 通过姓名查询用户
     * @param request
     * @param ownerName
     * @return
     */
    @RequestMapping("/selectOwnerInfoByName")
    public String selectOwnerInfoByName(HttpServletRequest request,String ownerName){
        List<OwnerInfo> ownerInfoByOwnerNameList = ownerInfoService.queryOwnerByName(ownerName);
        request.setAttribute("ownerInfoByOwnerNameList",ownerInfoByOwnerNameList);
        return "manager/manager_owner_information/manager_owner_information_select_page";
    }

    /**
     * 删除用户
     * @param owner_id
     * @return
     */
    @GetMapping("/delete_manager_owner_information")
    public String  deleteManagerOwnerInformation(int owner_id,HttpServletRequest request){
        ownerInfoService.deleteOwnerById(owner_id);
        return pageManagerOwnerInformation(request,PAGEDEFAULT);
    }

    /**
     * 修改信息
     * @return
     */
    @RequestMapping ("/update_manager_owner_information")
    public String updateManagerOwnerInformation(HttpServletRequest request,int owner_id,
                                                String owner_name,int owner_phone,
                                                String owner_address,String owner_password,
                                                String owner_identity){
        OwnerInfo ownerInfo = new OwnerInfo(owner_id,owner_name,owner_phone,owner_address,owner_password,owner_identity);
        int num = ownerInfoService.updateOwnerById(ownerInfo);
        System.out.println("修改数据库返回值："+num);
        return pageManagerOwnerInformation(request,PAGEDEFAULT);
    }



}
