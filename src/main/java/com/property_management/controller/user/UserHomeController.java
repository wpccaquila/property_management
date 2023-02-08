package com.property_management.controller.user;

import com.property_management.pojo.NoticeInfo;
import com.property_management.service.common.HouseholdInfoService;
import com.property_management.service.common.NoticeInfoService;
import com.property_management.service.common.impl.NoticeInfoServiceImpl;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UserHomeController {
    @Resource
    NoticeInfoService noticeInfoService;
    @Resource
    HouseholdInfoService householdInfoService;


    public void userHomeNotice(HttpServletRequest request,int userId){
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
//
//        //获取个人信息
//        householdInfoService.selectAllByHouseholdId(userId)
    }
}
