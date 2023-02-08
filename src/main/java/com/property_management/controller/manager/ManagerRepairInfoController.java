package com.property_management.controller.manager;

import com.github.pagehelper.PageInfo;
import com.property_management.pojo.RepairInfo;
import com.property_management.service.common.RepairInfoService;
import com.property_management.service.page.ManagerRepairInfoPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 管理员页面——用户报修维修管理控制器
 */
@Controller
public class ManagerRepairInfoController {
    // 分页时，每次返回多少条数据
    int PAGESIZE = 4;
    // 默认返回第一页
    int PAGEDEFAULT =0;

    @Resource
    RepairInfoService repairInfoService;
    @Resource
    ManagerRepairInfoPageService managerRepairInfoPageService;

    /**
     * 分页请求
     * @param request
     * @param pageNo 页码
     * @return
     */
    @RequestMapping("/pageManagerRepairInfoInformation")
    public String pageManagerRepairInfoInformation(HttpServletRequest request,int pageNo){
        // 计算当前开始的行号
        int startLineNo = managerRepairInfoPageService.getStartLineNo(pageNo);
        List<RepairInfo> repairByPageList = managerRepairInfoPageService.getRepairInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<RepairInfo> pageInfo = new PageInfo<>(repairByPageList);
        // 计算总页数
        int pages = managerRepairInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("repairPages",pages);
        request.setAttribute("repairStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("repairInfoList",repairByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("repairPageNo",pageNo);
        // 将pageInfo保存到域中
        request.setAttribute("repairPageInfo",pageInfo);
        return "manager/manager_repair_information/manager_repair_information_page";
    }

    /**
     * 默认的分页请求，默认为请求第一页
     * @return
     */
    @RequestMapping("/PAGE-DEFAULT-Repair")
    public String pageManagerOwnerInformation(HttpServletRequest request){
        // 计算当前开始的行号
        int startLineNo = managerRepairInfoPageService.getStartLineNo(PAGEDEFAULT);
        List<RepairInfo> repairByPageList = managerRepairInfoPageService.getRepairInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<RepairInfo> pageInfo = new PageInfo<>(repairByPageList);
        // 计算总页数
        int pages = managerRepairInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("repairPages",pages);
        request.setAttribute("repairStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("repairInfoList",repairByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("repairPageNo",PAGEDEFAULT);
        // 将pageInfo保存到域中
        request.setAttribute("repairPageInfo",pageInfo);
        return "manager/manager_repair_information/manager_repair_information_page";
    }

//    /**
//     * 返回所有维修信息
//     * @param request
//     * @return
//     */
//    @RequestMapping("/selectRepairAll")
//    public String selectRepairAll(HttpServletRequest request){
//        List<RepairInfo> repairInfoList = repairInfoService.selectAll();
//        request.setAttribute("repairInfoList",repairInfoList);
//        return "manager/manager_repair_information/manager_repair_information_page";
//    }

    /**
     * 删除报修信息
     * @param request
     * @param repairId
     * @return
     */
    @RequestMapping("/deleteRepairInfoById")
    public String deleteRepairInfoById(HttpServletRequest request,int repairId){
        repairInfoService.deleteByRepairId(repairId);
        return pageManagerOwnerInformation(request);
    }

    /**
     * 跳转到报修信息修改页面
     * @param request
     * @param repairId
     * @return
     */
    @RequestMapping("/forwardUpDataRepairInfoById")
    public String forwardUpDataRepairInfoById(HttpServletRequest request,int repairId){
        RepairInfo repairInfoById = repairInfoService.selectAllByRepairId(repairId);
        request.setAttribute("repairInfoById",repairInfoById);
        return "manager/manager_repair_information/manager_repair_updata_information_page";
    }

    /**
     * 修改报修信息
     * @param request
     * @param repairId
     * @return
     */
    @RequestMapping("/upDataRepairInfoById")
    public String upDataRepairInfoById(HttpServletRequest request,int repairId,String repairType,
                                       String repairContent,String repairCreateTime, String repairApplicant,
                                       String repairState,String repairProcessor) throws ParseException {
        // 转换时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("yy-MM-dd");
        Date repairCreateTimeDate=dateFormat.parse(repairCreateTime);

        repairInfoService.modifyRepairByRepairId(new RepairInfo(repairId,repairType,
                                                    repairContent,repairCreateTimeDate,
                                                    repairApplicant,repairState,repairProcessor));
        return pageManagerOwnerInformation(request);
    }

    /**
     * 通过报修类型查询
     * @param repairTitle
     * @param request
     * @return
     */
    @RequestMapping("selectRepairByType")
    public String selectRepairByType(String repairTitle,HttpServletRequest request){
        if(repairTitle!=null&&repairTitle!=""){
            List<RepairInfo> repairInfoListByType = repairInfoService.searchAllByRepairType(repairTitle);
            request.setAttribute("repairInfoListByType",repairInfoListByType);
            return "manager/manager_repair_information/manager_repair_select_information_page";
        }
        return pageManagerOwnerInformation(request);
    }


}
