package com.property_management.controller.manager;

import com.github.pagehelper.PageInfo;
import com.property_management.pojo.BuildingInfo;
import com.property_management.pojo.ComplaintsInfo;
import com.property_management.pojo.NoticeInfo;
import com.property_management.service.common.BuildingInfoService;
import com.property_management.service.page.ManagerBuildingInfoPageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ManagerBuildingInfoController {
    // 分页时，每次返回多少条数据
    int PAGESIZE = 4;
    // 默认返回第一页
    int PAGEDEFAULT =0;

    @Resource
    BuildingInfoService buildingInfoService;
    @Resource
    ManagerBuildingInfoPageService managerBuildingInfoPageService;

    /**
     * 分页请求
     * @param request
     * @param pageNo 页码
     * @return
     */
    @RequestMapping("/pageManagerBuildingInfoInformation")
    public String pageManagerBuildingInfoInformation(HttpServletRequest request, int pageNo){
        // 计算当前开始的行号
        int startLineNo = managerBuildingInfoPageService.getStartLineNo(pageNo);
        List<BuildingInfo>buildingByPageList = managerBuildingInfoPageService.getBuildingInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<BuildingInfo> pageInfo = new PageInfo<>(buildingByPageList);
        // 计算总页数
        int pages = managerBuildingInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("buildingPages",pages);
        request.setAttribute("buildingStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("buildingInfoList",buildingByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("buildingPageNo",pageNo);
        // 将pageInfo保存到域中
        request.setAttribute("buildingPageInfo",pageInfo);
        return "manager/manager_building_information/manager_building_information_page";
    }

    /**
     * 默认的分页请求，默认为请求第一页
     * @return
     */
    @RequestMapping("/PAGE-DEFAULT-Building")
    public String pageManagerBuildingInfoInformation(HttpServletRequest request){
        // 计算当前开始的行号
        int startLineNo = managerBuildingInfoPageService.getStartLineNo(PAGEDEFAULT);
        List<BuildingInfo>buildingByPageList = managerBuildingInfoPageService.getBuildingInfoByPage(startLineNo, PAGESIZE);
        // 将数据保存到PageHelper插件中自带的PageInfo实体类中
        PageInfo<BuildingInfo> pageInfo = new PageInfo<>(buildingByPageList);
        // 计算总页数
        int pages = managerBuildingInfoPageService.getPageNumber(PAGESIZE);
        request.setAttribute("buildingPages",pages);
        request.setAttribute("buildingStartLineNo",startLineNo);
        // 将返回的用户信息表储存到域中
        request.setAttribute("buildingInfoList",buildingByPageList);
        // 将当前页开始的页码储存到域中
        request.setAttribute("buildingPageNo",PAGEDEFAULT);
        // 将pageInfo保存到域中
        request.setAttribute("buildingPageInfo",pageInfo);
        return "manager/manager_building_information/manager_building_information_page";
    }

    /**
     * 删除楼房信息
     * @return
     */
    @RequestMapping("/deleteBuildingInfoById")
    public String deleteBuildingInfoById(HttpServletRequest request, int buildingId){
        buildingInfoService.deleteByBuildingId(buildingId);
        return pageManagerBuildingInfoInformation(request);
    }

    /**
     * 跳转到新增页面
     * @return
     */
    @RequestMapping("/forwardAddBuildingInfo")
    public String forwardAddBuildingInfo(){
        return "manager/manager_building_information/manager_building_insert_page";
    }

    /**
     * 新增楼房信息
     * @return
     */
    @RequestMapping("/addBuildingInfo")
    public String addBuildingInfo(HttpServletRequest request, String buildingNum,String unitNum,
                                  String roomNum, String ownerName, String ownerPhone){
        if(ownerName != null&&!ownerName.trim().isEmpty()&&ownerPhone != null&&!ownerPhone.trim().isEmpty()){
            buildingInfoService.addAll(new BuildingInfo(null,buildingNum,unitNum,roomNum,ownerName,ownerPhone));
        }else {
            buildingInfoService.addAll(new BuildingInfo(null,buildingNum,unitNum,roomNum,null,null));
        }
        return pageManagerBuildingInfoInformation(request);
    }

    /**
     * 跳转到修改页面界面
     * @param request
     * @param buildingId
     * @return
     */
    @RequestMapping("/forwardUpDataBuildingInfo")
    public String forwardUpDataBuildingInfo(HttpServletRequest request,int buildingId){
        BuildingInfo buildingInfo = buildingInfoService.selectAllByBuildingId(buildingId);
        request.setAttribute("buildingInfo",buildingInfo);
        return "manager/manager_building_information/manager_building_updata_page";
    }

    /**
     * 修改楼房信息
     * @return
     */
    @RequestMapping("/upDataBuildingInfo")
    public String upDataBuildingInfo(HttpServletRequest request,int buildingId ,String buildingNum,String unitNum,
                                  String roomNum, String ownerName, String ownerPhone){
        buildingInfoService.updateBuildingInfo(new BuildingInfo(buildingId,buildingNum,unitNum,roomNum,ownerName,ownerPhone));
        return pageManagerBuildingInfoInformation(request);
    }


    /**
     * 查询房屋信息
     * @return
     */
    @RequestMapping("/selectBuildingInfo")
    public String selectBuildingInfo(HttpServletRequest request,String buildingNum,String unitNum, String roomNum){
        if(buildingNum != null && !buildingNum.trim().isEmpty()) {
            List<BuildingInfo> selectBuildingInfos = buildingInfoService.selectAllByBuildingNumAndUnitNumAndRoomNum(buildingNum, unitNum, roomNum);
            request.setAttribute("selectBuildingInfos", selectBuildingInfos);
            return "manager/manager_building_information/manager_building_select_page";
        }
        return pageManagerBuildingInfoInformation(request);
    }

}
