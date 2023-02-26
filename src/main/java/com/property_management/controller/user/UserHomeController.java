package com.property_management.controller.user;

import com.property_management.mapper.ComplaintsInfoMapper;
import com.property_management.pojo.*;
import com.property_management.service.common.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserHomeController {
    @Resource
    NoticeInfoService noticeInfoService;
    @Resource
    OwnerInfoService ownerInfoService;
    @Resource
    HouseholdInfoService householdInfoService;
    @Resource
    RepairInfoService repairInfoService;
    @Resource
    ComplaintsInfoMapper complaintsInfoMapper;
    @Resource
    HouseholdPaymentInfoService householdPaymentInfoService;
    @Resource
    private HttpSession session;

    /**
     * 获取当前用户的各种信息
     * @param request
     * @param ownerPhone
     */
    @RequestMapping("/currentUserHomeInfo")
    public String currentUserHomeInfo(HttpServletRequest request,String ownerPhone){
        //获取最新的一条公告
        NoticeInfo latestNotice = noticeInfoService.findLatestNotice();
        // 转换时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String latestNoticeDate = sdf.format(latestNotice.getNoticeCreateTime());
        request.setAttribute("latestNoticeDate",latestNoticeDate);
        request.setAttribute("latestNotice",latestNotice);

        //显示前四条公告
        List<NoticeInfo> fourLatestNoticeList = noticeInfoService.findFourLatestNotice();
        request.setAttribute("fourLatestNoticeList",fourLatestNoticeList);

        //获取用户信息
        OwnerInfo currentOwnerInfo = ownerInfoService.selectByOwner_phone(ownerPhone);
        session.setAttribute("currentOwnerInfo",currentOwnerInfo);

        //获取住户信息
        HouseholdInfo currentHouseholdInfo = householdInfoService.selectAllByOwnerPhone(ownerPhone);
        session.setAttribute("currentHouseholdInfo",currentHouseholdInfo);

        //获取报修信息
        List<RepairInfo> currentRepairInfoList = repairInfoService.selectAllByOwnerPhone(ownerPhone);
        session.setAttribute("currentRepairInfoList",currentRepairInfoList);

        // 获取投诉信息
        List<ComplaintsInfo> currentComplaintsInfos = complaintsInfoMapper.selectAllByOwnerPhone(ownerPhone);
        session.setAttribute("currentComplaintsInfos",currentComplaintsInfos);

        // 获取缴费信息
        List<HouseholdPaymentInfo> currentHouseholdPaymentInfoList = householdPaymentInfoService.selectAllByOwnerPhone(ownerPhone);
        session.setAttribute("currentHouseholdPaymentInfoList",currentHouseholdPaymentInfoList);
        return "user/user_home_page";
    }

    /**
     * 用户报修
     * @param ownerPhone
     * @param ownerName
     * @return
     */
    @RequestMapping("/addRepairInfo")
    public String addRepairInfo(String ownerPhone,String ownerName,String repairType,String repairContent,HttpServletRequest request){
        Date repairTime = new Date();
        repairInfoService.addRepair(new RepairInfo(repairType,repairContent,repairTime,ownerName,ownerPhone,"未处理","老李","",null,""));
        return currentUserHomeInfo(request,ownerPhone);
    }


    /**
     * 提交用户报修评价
     * @return
     */
    @RequestMapping("/submitRepairAppraise")
    public String submitRepairAppraise (String ownerPhone,int cuRepairId,String repairAppraise,HttpServletRequest request){
        repairInfoService.modifyRepairAppraiseByRepairId(repairAppraise, cuRepairId);
        return currentUserHomeInfo(request,ownerPhone);
    }

    /**
     * 用户提交投诉
     * @param request
     * @param complaintContent
     * @return
     */
    @RequestMapping("/addComplaintInfo")
    public String addComplaintInfo(HttpServletRequest request,String ownerPhone,String ownerName,
                                   String complaintContent){
        Date complaintTime = new Date();
        complaintsInfoMapper.addAll(new ComplaintsInfo(complaintTime,complaintContent,ownerName,ownerPhone,"未处理","","",null));
        return currentUserHomeInfo(request,ownerPhone);
    }

    /**
     * 提交用户投诉反馈评价
     * @return
     */
    @RequestMapping("/submitComplaintAppraise")
    public String submitComplaintAppraise (String ownerPhone,int cuComplaintId,String userEvaluation,HttpServletRequest request){
        complaintsInfoMapper.modifyUserEvaluationByComplaintId(userEvaluation, cuComplaintId);
        return currentUserHomeInfo(request,ownerPhone);
    }




}
