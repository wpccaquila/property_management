package com.property_management.controller.manager;

import com.property_management.pojo.HouseholdPaymentInfo;
import com.property_management.service.common.HouseholdPaymentInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 管理员页面——住户缴费信息管理控制器
 */
@Controller
public class ManagerHouseholdPaymentInfoController {
    @Resource
    HouseholdPaymentInfoService householdPaymentInfoService;
    /**
     * 跳转到缴费首页
     * @return
     */
    @RequestMapping("/forwardPaymentHome")
    public String forwardPaymentHome(){
        return "manager/manager_household_payment_information/manager_household_payment_page";
    }

    /**
     * 返回所有缴费信息
     * @return
     */
    @RequestMapping("/selectAllPaymentInfo")
    public String selectAllPaymentInfo(HttpServletRequest request){
        List<HouseholdPaymentInfo> householdPaymentInfoList = householdPaymentInfoService.selectAll();
        request.setAttribute("householdPaymentInfoList",householdPaymentInfoList);

        return forwardPaymentHome();
    }

}
