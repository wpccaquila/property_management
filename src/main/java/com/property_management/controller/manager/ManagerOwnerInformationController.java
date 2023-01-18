package com.property_management.controller.manager;

import com.property_management.pojo.OwnerInfo;
import com.property_management.service.manager.page.ManagerOwnerInformationPageService;
import org.springframework.stereotype.Controller;
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
    int PAGESIZE = 2;

    @Resource
    ManagerOwnerInformationPageService managerOwnerInformationPageService;

    /**
     * 跳转到管理用户信息页面
     * @return
     */
    @RequestMapping("/forward_manager_owner_information_page")
    public String forwardManagerOwnerInformationPage(){
        return "manager/manager_owner_information_page";
    }

    /**
     * 用户信息表格信息分页返回
     * @param pageNum 请求的页码
     * @return
     */
//    @RequestMapping("/page_manager_owner_information")
//    public String pageManagerOwnerInformation(Integer pageNum, HttpServletRequest request){
//        // 如果没有请求页码参数时，默认请求第一页的数据
//        if (pageNum == null)  pageNum = 1;
//
//        List<OwnerInfo> ownerInfoList = managerOwnerInformationPageService.getOwnerInfoList(pageNum, PAGESIZE);
//        // 将返回的数据放入域中，到页面里进行遍历
//        request.setAttribute("Page_ownerInfoList",ownerInfoList);
//        return "manager/manager_owner_information_page";
//    }

    @RequestMapping("/page_manager_owner_information")
    public List<OwnerInfo> pageManagerOwnerInformation(Integer pageNum, HttpServletRequest request){
        // 如果没有请求页码参数时，默认请求第一页的数据
        if (pageNum == null)  pageNum = 1;

        List<OwnerInfo> ownerInfoList = managerOwnerInformationPageService.getOwnerInfoList(pageNum, PAGESIZE);
        // 将返回的数据放入域中，到页面里进行遍历
        request.setAttribute("Page_ownerInfoList",ownerInfoList);
        return ownerInfoList;
    }

}
