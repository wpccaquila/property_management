package com.property_management.controller.manager;

import com.github.pagehelper.PageInfo;
import com.property_management.pojo.ComplaintsInfo;
import com.property_management.service.common.ComplaintsInfoService;
import com.property_management.service.page.ManagerComplaintsInfoPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ManagerComplaintsInfoController {
    // 分页时，每次返回多少条数据
    int PAGESIZE = 4;
    // 默认返回第一页
    int PAGEDEFAULT =0;

    @Resource
    ComplaintsInfoService complaintsInfoService;
    @Resource
    ManagerComplaintsInfoPageService managerComplaintsInfoPageService;

    /**
     * 分页请求
     * @param request
     * @param pageNo 页码
     * @return
     */
    @RequestMapping("/pageManagerComplaintsInfoInformation")
    public String pageManagerComplaintsInfoInformation(HttpServletRequest request, int pageNo){
        // 计算当前开始的行号
        int startLineNo = managerComplaintsInfoPageService.getStartLineNo(pageNo);
        List<ComplaintsInfo> complaintsByPageList = managerComplaintsInfoPageService.getComplaintsInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<ComplaintsInfo> pageInfo = new PageInfo<>(complaintsByPageList);
        // 计算总页数
        int pages = managerComplaintsInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("complaintsPages",pages);
        request.setAttribute("complaintsStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("complaintsInfoList",complaintsByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("complaintsPageNo",pageNo);
        // 将pageInfo保存到域中
        request.setAttribute("complaintsPageInfo",pageInfo);
        return "manager/manager_complaints_information/manager_complaints_information_page";
    }

    /**
     * 默认的分页请求，默认为请求第一页
     * @return
     */
    @RequestMapping("/PAGE-DEFAULT-Complaints")
    public String pageManagerComplaintsInfoInformation(HttpServletRequest request){
        // 计算当前开始的行号
        int startLineNo = managerComplaintsInfoPageService.getStartLineNo(PAGEDEFAULT);
        List<ComplaintsInfo> complaintsByPageList = managerComplaintsInfoPageService.getComplaintsInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<ComplaintsInfo> pageInfo = new PageInfo<>(complaintsByPageList);
        // 计算总页数
        int pages = managerComplaintsInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("complaintsPages",pages);
        request.setAttribute("complaintsStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("complaintsInfoList",complaintsByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("complaintsPageNo",PAGEDEFAULT);
        // 将pageInfo保存到域中
        request.setAttribute("complaintsPageInfo",pageInfo);
        return "manager/manager_complaints_information/manager_complaints_information_page";
    }

    /**
     * 删除投诉信息
     * @param request
     * @param complaintId
     * @return
     */
    @RequestMapping("/deleteComplaintsInfoById")
    public String deleteComplaintsInfoById(HttpServletRequest request,int complaintId){
        complaintsInfoService.deleteByComplaintId(complaintId);
        return pageManagerComplaintsInfoInformation(request);
    }

    /**
     * 跳转到修改界面
     * @param request
     * @param complaintId
     * @return
     */
    @RequestMapping("/forwardUpdateComplaintsInfoById")
    public String forwardUpdateComplaintsInfoById(HttpServletRequest request,int complaintId){
        ComplaintsInfo complaintsInfoById = complaintsInfoService.selectAllByComplaintId(complaintId);
        request.setAttribute("complaintsInfoById",complaintsInfoById);
        return "manager/manager_complaints_information/manager_complaints_updata_page";
    }

    /**
     * 修改投诉信息
     * @return
     * @throws ParseException
     */
    @RequestMapping("/updateComplaintsInfoById")
    public String updateComplaintsInfoById(HttpServletRequest request,int complaintId,String complaintTime,
                                           String complaintContent,String complaintName,String complaintPhone,
                                           String complaintStatus) throws ParseException {
        // 转换时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("yy-MM-dd");
        Date complaintTimeDate=dateFormat.parse(complaintTime);

        complaintsInfoService.updateComplaintInfo(new ComplaintsInfo(complaintId,complaintTimeDate,complaintContent,complaintName,complaintPhone,complaintStatus));

        return pageManagerComplaintsInfoInformation(request);
    }

    /**
     * 通过姓名查询
     * @param request
     * @param complaintName
     * @return
     */
    @RequestMapping("/selectComplaintsInfoByName")
    public String selectComplaintsInfoByName(HttpServletRequest request,String complaintName){
        List<ComplaintsInfo> complaintsInfoByName = complaintsInfoService.selectAllByComplaintName(complaintName);
        request.setAttribute("complaintsInfoByName",complaintsInfoByName);
        return  "manager/manager_complaints_information/manager_complaints_select_page";
    }



}
