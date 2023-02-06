package com.property_management.controller.manager;


import com.github.pagehelper.PageInfo;
import com.property_management.pojo.OwnerInfo;
import com.property_management.service.common.OwnerInfoService;
import com.property_management.service.manager.page.ManagerOwnerInfoPageService;
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
public class ManagerOwnerInfoController {
    // 分页时，每次返回多少条数据
    int PAGESIZE = 4;
    // 默认返回第一页
    int PAGEDEFAULT =0;

    @Resource
    ManagerOwnerInfoPageService managerOwnerInfoPageService;
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
     * 分页请求
     * @param request
     * @param pageNo 页码
     * @return
     */
    @RequestMapping("/page_manager_owner_information")
    public String pageManagerOwnerInformation(HttpServletRequest request,int pageNo){
        // 计算当前开始的行号
        int startLineNo = managerOwnerInfoPageService.getStartLineNo(pageNo);
        List<OwnerInfo> ownerInfoByPageList = managerOwnerInfoPageService.getOwnerInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<OwnerInfo> pageInfo = new PageInfo<>(ownerInfoByPageList);
        // 计算总页数
        int pages = managerOwnerInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("ownerPages",pages);
        request.setAttribute("ownerStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("ownerInfoList",ownerInfoByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("ownerPageNo",pageNo);
        // 将pageInfo保存到域中
        request.setAttribute("ownerInfoPageInfo",pageInfo);
        return "manager/manager_owner_information/manager_owner_information_page";
    }

    /**
     * 默认的分页请求，默认为请求第一页
     * @return
     */
    @RequestMapping("/PAGE-DEFAULT-Owner")
    public String pageManagerOwnerInformation(HttpServletRequest request){
        // 计算当前开始的行号
        int startLineNo = managerOwnerInfoPageService.getStartLineNo(PAGEDEFAULT);
        List<OwnerInfo> ownerInfoByPageList = managerOwnerInfoPageService.getOwnerInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<OwnerInfo> pageInfo = new PageInfo<>(ownerInfoByPageList);
        // 计算总页数
        int pages = managerOwnerInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("ownerPages",pages);
        request.setAttribute("ownerStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("ownerInfoList",ownerInfoByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("ownerPageNo",PAGEDEFAULT);
        // 将pageInfo保存到域中
        request.setAttribute("ownerInfoPageInfo",pageInfo);
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
        if(ownerName!=null&&ownerName!=""){
            List<OwnerInfo> ownerInfoByOwnerNameList = ownerInfoService.queryOwnerByName(ownerName);
            request.setAttribute("ownerInfoByOwnerNameList",ownerInfoByOwnerNameList);
            return "manager/manager_owner_information/manager_owner_information_select_page";
        }
        return pageManagerOwnerInformation(request,PAGEDEFAULT);
    }

    /**
     * 删除用户
     * @param ownerId
     * @return
     */
    @GetMapping("/delete_manager_owner_information")
    public String  deleteManagerOwnerInformation(int ownerId,HttpServletRequest request){
        ownerInfoService.deleteOwnerById(ownerId);
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

    @RequestMapping("/forwardHomePage")
    public String forwardHomePage(){
        return "manager/manager_home_page";
    }



}
