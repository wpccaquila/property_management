package com.property_management.controller.manager;

import com.github.pagehelper.PageInfo;
import com.property_management.pojo.HouseholdPaymentInfo;
import com.property_management.service.common.HouseholdPaymentInfoService;
import com.property_management.service.page.ManagerHouseholdPaymentInfoPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 管理员页面——住户缴费信息管理控制器
 */
@Controller
public class ManagerHouseholdPaymentInfoController {
    // 分页时，每次返回多少条数据
    int PAGESIZE = 4;
    // 默认返回第一页
    int PAGEDEFAULT =0;
    @Resource
    HouseholdPaymentInfoService householdPaymentInfoService;
    @Resource
    ManagerHouseholdPaymentInfoPageService managerHouseholdPaymentInfoPageService;
    /**
     * 跳转到缴费首页
     * @return
     */
    @RequestMapping("/forwardPaymentHome")
    public String forwardPaymentHome(){
        return "manager/manager_household_payment_information/manager_household_payment_page";
    }

    /**
     * 分页请求
     * @param request
     * @param pageNo 页码
     * @return
     */
    @RequestMapping("/pageManagerHouseholdPaymentInfo")
    public String pageManagerHouseholdPaymentInfo(HttpServletRequest request,int pageNo){
        // 计算当前开始的行号
        int startLineNo = managerHouseholdPaymentInfoPageService.getStartLineNo(pageNo);
        List<HouseholdPaymentInfo> householdPaymentByPageList = managerHouseholdPaymentInfoPageService.getHouseholdPaymentInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<HouseholdPaymentInfo> pageInfo = new PageInfo<>(householdPaymentByPageList);
        // 计算总页数
        int pages = managerHouseholdPaymentInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("householdPaymentPages",pages);
        request.setAttribute("householdPaymentStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("householdPaymentByPageList",householdPaymentByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("householdPaymentPageNo",pageNo);
        // 将pageInfo保存到域中
        request.setAttribute("householdPaymentPageInfo",pageInfo);
        return "manager/manager_household_payment_information/manager_household_payment_page";
    }

    /**
     * 默认的分页请求，默认为请求第一页
     * @return
     */
    @RequestMapping("/PAGE-DEFAULT-Payment")
    public String pageManagerHouseholdPaymentInfo(HttpServletRequest request){
        // 计算当前开始的行号
        int startLineNo = managerHouseholdPaymentInfoPageService.getStartLineNo(PAGEDEFAULT);
        List<HouseholdPaymentInfo> householdPaymentByPageList = managerHouseholdPaymentInfoPageService.getHouseholdPaymentInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<HouseholdPaymentInfo> pageInfo = new PageInfo<>(householdPaymentByPageList);
        // 计算总页数
        int pages = managerHouseholdPaymentInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("householdPaymentPages",pages);
        request.setAttribute("householdPaymentStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("householdPaymentByPageList",householdPaymentByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("householdPaymentPageNo",PAGEDEFAULT);
        // 将pageInfo保存到域中
        request.setAttribute("householdPaymentPageInfo",pageInfo);
        return "manager/manager_household_payment_information/manager_household_payment_page";
    }

//    /**
//     * 返回所有缴费信息
//     * @return
//     */
//    @RequestMapping("/selectAllPaymentInfo")
//    public String selectAllPaymentInfo(HttpServletRequest request){
//        List<HouseholdPaymentInfo> householdPaymentInfoList = householdPaymentInfoService.selectAll();
//        request.setAttribute("householdPaymentInfoList",householdPaymentInfoList);
//        return forwardPaymentHome();
//    }

    /**
     * 跳转到更新页面的首页,并传递ID检索后的信息
     * @param request
     * @param propertyPaymentId 通过ID号检索信息
     * @return
     */
    @RequestMapping("/forwardUpdateHouseholdPaymentPage")
    public String forwardUpdateHouseholdPaymentPage(HttpServletRequest request,int propertyPaymentId){
        HouseholdPaymentInfo householdPaymentById = householdPaymentInfoService.selectAllByPropertyPaymentId(propertyPaymentId);
        request.setAttribute("householdPaymentById",householdPaymentById);
        return "manager/manager_household_payment_information/manager_household_payment_updata_page";
    }


    /**
     * 修改住户缴费信息
     * @return
     */
    @RequestMapping("updataPaymentInfoById")
    public String updataPaymentInfoById(HttpServletRequest request,int propertyPaymentId, String paymentType,BigDecimal paymentAmount, String paymentMethod, String paymentTime, String paymentStatus) throws ParseException {

        // 转换时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("yy-MM-dd");
        Date paymentTimeDate=dateFormat.parse(paymentTime);

        householdPaymentInfoService.modifyHouseholdPaymentInfo(new HouseholdPaymentInfo(propertyPaymentId,paymentType,new BigDecimal(String.valueOf(paymentAmount)),paymentMethod,paymentTimeDate,paymentStatus));
        return pageManagerHouseholdPaymentInfo(request);
    }

    /**
     * 删除缴费信息,通过ID号
     * @param request
     * @param propertyPaymentId
     * @return
     */
    @RequestMapping("deletePaymentInfoById")
    public String deletePaymentInfoById(HttpServletRequest request,int propertyPaymentId) {
        householdPaymentInfoService.deleteByPropertyPaymentId(propertyPaymentId);
        return pageManagerHouseholdPaymentInfo(request);
    }


    /**
     * 通过名字查询
     * @param householdPaymentName
     * @param request
     * @return
     */
    @RequestMapping("selectPaymentByName")
    public String selectPaymentByName(String householdPaymentName,HttpServletRequest request){
        if(householdPaymentName!=null&&householdPaymentName!=""){
            List<HouseholdPaymentInfo> householdPaymentByNameList = householdPaymentInfoService.selectAllByHouseholdName(householdPaymentName);
            request.setAttribute("householdPaymentByNameList",householdPaymentByNameList);
            return "manager/manager_household_payment_information/manager_household_payment_select_page";
        }
        return pageManagerHouseholdPaymentInfo(request);
    }

    /**
     * 跳转到增加缴费信息页面
     * @return
     */
    @RequestMapping("/forwardInsertPayment")
    public String forwardInsertPayment(){
        return "manager/manager_household_payment_information/manager_household_payment_insert_page";
    }

    /**
     * 增加缴费信息
     * @return
     * @throws ParseException
     */
    @RequestMapping("insertPaymentInfo")
    public String insertPaymentInfo(HttpServletRequest request,
                                        String ownerPhone, String ownerName,String paymentType,
                                        BigDecimal paymentAmount, String paymentMethod,
                                        String paymentTime, String paymentStatus) throws ParseException {
        // 转换时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date paymentTimeDate=dateFormat.parse(paymentTime);

        householdPaymentInfoService.addAll(new HouseholdPaymentInfo(ownerPhone,ownerName,paymentType,new BigDecimal(String.valueOf(paymentAmount)),paymentMethod,paymentTimeDate,paymentStatus));
        return pageManagerHouseholdPaymentInfo(request);
    }


}
