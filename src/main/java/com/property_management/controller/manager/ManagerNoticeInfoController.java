package com.property_management.controller.manager;


import com.github.pagehelper.PageInfo;
import com.property_management.pojo.HouseholdInfo;
import com.property_management.pojo.NoticeInfo;
import com.property_management.service.common.NoticeInfoService;
import com.property_management.service.page.ManagerNoticeInfoPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 管理员页面——公告信息管理控制器
 */
@Controller
public class ManagerNoticeInfoController {
    // 分页时，每次返回多少条数据
    int PAGESIZE = 4;
    // 默认返回第一页
    int PAGEDEFAULT =0;
    @Resource
    NoticeInfoService noticeInfoService;
    @Resource
    ManagerNoticeInfoPageService managerNoticeInfoPageService;

    /**
     * 跳转到公告信息首页
     * @return
     */
    @RequestMapping("/forwardNoticeHome")
    public String forwardNoticeHome(){
        return "manager/manager_notice_information/manager_notice_information_page";
    }

//    /**
//     * 请求所有用户数据
//     * @param request
//     * @return
//     */
//    @RequestMapping("/selectAllNotice")
//    public String selectAllNotice(HttpServletRequest request){
//        List<NoticeInfo> noticeInfoList = noticeInfoService.selectAll();
//        request.setAttribute("noticeInfoList",noticeInfoList);
//        return "manager/manager_notice_information/manager_notice_information_page";
//    }

    /**
     * 分页请求
     * @param request
     * @param pageNo 页码
     * @return
     */
    @RequestMapping("/pageManagerNoticeInformation")
    public String pageManagerNoticeInformation(HttpServletRequest request,int pageNo){
        // 计算当前开始的行号
        int startLineNo = managerNoticeInfoPageService.getStartLineNo(pageNo);
        List<NoticeInfo> noticeInfoByPageList = managerNoticeInfoPageService.getNoticeInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<NoticeInfo> pageInfo = new PageInfo<>(noticeInfoByPageList);
        // 计算总页数
        int pages = managerNoticeInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("noticePages",pages);
        request.setAttribute("noticeStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("noticeInfoList",noticeInfoByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("noticePageNo",pageNo);
        // 将pageInfo保存到域中
        request.setAttribute("noticeInfoPageInfo",pageInfo);
        return "manager/manager_notice_information/manager_notice_information_page";
    }

    /**
     * 默认的分页请求，默认为请求第一页
     * @return
     */
    @RequestMapping("/PAGE-DEFAULT-Notice")
    public String pageManagerNoticeInformation(HttpServletRequest request){
        // 计算当前开始的行号
        int startLineNo = managerNoticeInfoPageService.getStartLineNo(PAGEDEFAULT);
        List<NoticeInfo> noticeInfoByPageList = managerNoticeInfoPageService.getNoticeInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<NoticeInfo> pageInfo = new PageInfo<>(noticeInfoByPageList);
        // 计算总页数
        int pages = managerNoticeInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("noticePages",pages);
        request.setAttribute("noticeStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("noticeInfoList",noticeInfoByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("noticePageNo",PAGEDEFAULT);
        // 将pageInfo保存到域中
        request.setAttribute("noticeInfoPageInfo",pageInfo);
        return "manager/manager_notice_information/manager_notice_information_page";
    }

    /**
     * 删除公告
     * @param request
     * @param noticeId
     * @return
     */
    @RequestMapping("deleteNoticeInfoById")
    public String deleteNoticeInfoById(HttpServletRequest request,int noticeId){
        noticeInfoService.deleteByNoticeId(noticeId);
        return pageManagerNoticeInformation(request);
    }

    /**
     * 跳转到更新页面的首页,并传递ID检索后的信息
     * @param request
     * @param noticeId 通过ID号检索信息
     * @return
     */
    @RequestMapping("/forwardUpDataNoticeInfoPage")
    public String forwardUpDataNoticeInfoPage(HttpServletRequest request,int noticeId){
        NoticeInfo noticeInfoById = noticeInfoService.selectAllByNoticeId(noticeId);
        request.setAttribute("noticeInfoById",noticeInfoById);
        return "manager/manager_notice_information/manager_notice_updata_page";
    }

    /**
     * 修改公告信息
     * @return
     * @throws ParseException
     */
    @RequestMapping("upDataNoticeInfoById")
    public String upDataNoticeInfoById(HttpServletRequest request,int noticeId,String noticeTitle,
                                       String noticeContent, String noticeCreateTime, String noticeCreateUser) throws ParseException {
        // 转换时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("yy-MM-dd");
        Date noticeCreateTimeDate=dateFormat.parse(noticeCreateTime);

        noticeInfoService.modifyNoticeInfo(new NoticeInfo(noticeId,noticeTitle,noticeContent,noticeCreateTimeDate,noticeCreateUser));
        return pageManagerNoticeInformation(request);
    }

    /**
     * 通过标题查询
     * @param request
     * @param noticeTitle
     * @return
     */
    @RequestMapping("/selectNoticeByTitle")
    public String selectNoticeByTitle(HttpServletRequest request, String noticeTitle){
        if(noticeTitle != null && !noticeTitle.trim().isEmpty()){
            List<NoticeInfo> selectNoticeInfoByNameList = noticeInfoService.selectAllByNoticeTitleName(noticeTitle);
            request.setAttribute("selectNoticeInfoByNameList",selectNoticeInfoByNameList);
            return "manager/manager_notice_information/manager_notice_select_page";
        }
        return pageManagerNoticeInformation(request);
    }

    /**
     * 跳转到发布公告页面
     * @return
     */
    @RequestMapping("forwardInsertNoticePage")
    public String forwardInsertNoticePage(){
        return "manager/manager_notice_information/manager_notice_insert_page";
    }

    /**
     * 发布公告
     * @return
     * @throws ParseException
     */
    @RequestMapping("insertNotice")
    public String insertNotice(HttpServletRequest request,String noticeTitle,
                               String noticeContent, String noticeCreateTime,
                               String noticeCreateUser) throws ParseException {
        // 转换时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("yy-MM-dd");
        Date noticeCreateTimeDate=dateFormat.parse(noticeCreateTime);

        noticeInfoService.addAll(new NoticeInfo(noticeTitle,noticeContent,noticeCreateTimeDate,noticeCreateUser));
        return pageManagerNoticeInformation(request);
    }


}
