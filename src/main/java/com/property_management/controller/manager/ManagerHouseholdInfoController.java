package com.property_management.controller.manager;

import com.property_management.pojo.HouseholdInfo;
import com.property_management.service.common.HouseholdInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 管理员页面——住户信息管理控制器
 */
@Controller
public class ManagerHouseholdInfoController {
    // 分页时，每次返回多少条数据
    int PAGESIZE = 4;
    // 默认返回第一页
    int PAGEDEFAULT =0;
    @Resource
    HouseholdInfoService householdInfoService;

    /**
     * 跳转到住户信息首页
     * @return
     */
    @RequestMapping("/forwardManagerHouseholdInformationPage")
    public String forwardManagerHouseholdInformationPage(){
        return "manager/manager_household_information/manager_household_information_page";
    }

    /**
     * 跳转到添加住户信息页面
     * @return
     */
    @RequestMapping("/forwardAddHouseholdInformationPage")
    public String forwardAddHouseholdInformationPage(){
        return "manager/manager_household_information/add_household_page";
    }

    /**
     * 添加住户信息
     * @return
     */
    @RequestMapping("addHouseholdInfo")
    public String addHouseholdInfo(HttpServletRequest request,String household_name,String household_id_number,String household_birthday,
                                   String household_gender,Integer household_phone,String household_checkin_time,
                                   String household_house_type,String household_address_unit,String household_address_building,
                                   String household_address_room){
        // 将地址信息统一格式
        String household_address = household_address_unit + "幢" + household_address_building + "单元" + household_address_room + "室";
        householdInfoService.addAll(new HouseholdInfo(household_name, household_id_number,
                                        household_birthday, household_gender, household_phone,
                                        household_checkin_time, household_house_type, household_address));
        return selectAllHousehold(request);
    }

    /**
     * 请求所有用户数据
     * @param request
     * @return
     */
    @RequestMapping("/selectAllHousehold")
    public String selectAllHousehold(HttpServletRequest request){
        List<HouseholdInfo> householdInfoList = householdInfoService.selectAllHousehold();
        request.setAttribute("householdInfoList",householdInfoList);
        return "manager/manager_household_information/manager_household_information_page";
    }

    /**
     * 跳转到修改界面，并且查询数据回显
     * @param householdId
     * @return
     */
    @RequestMapping("/forwardUpdateHouseholdPage")
    public String forwardUpdateHouseholdPage(HttpServletRequest request,int householdId){
        HouseholdInfo householdInfoById = householdInfoService.selectAllByHouseholdId(householdId);
        request.setAttribute("householdInfoById",householdInfoById);
        //使用String.split()方法拆分字符串，并使用中括号截取需要的字符
        String[] symbol = householdInfoById.getHouseholdAddress().split("幢|单元|室");
        request.setAttribute("household_address_unit",symbol[0]);
        request.setAttribute("household_address_building",symbol[1]);
        request.setAttribute("household_address_room",symbol[2]);

        return "manager/manager_household_information/manager_update_household_page";
    }

    /**
     * 修改住户信息
     * @return
     */
    @RequestMapping("/updateHouseholdById")
    public String updateHouseholdById(HttpServletRequest request,int householdId,String household_name,
                                      String household_id_number,String household_birthday,
                                      String household_gender,Integer household_phone,String household_checkin_time,
                                      String household_house_type,String household_address_unit,String household_address_building,
                                      String household_address_room){
        // 将地址信息统一格式
        String household_address = household_address_unit + "幢" + household_address_building + "单元" + household_address_room + "室";
        householdInfoService.modifyHousehold(new HouseholdInfo(householdId,household_name, household_id_number,
                household_birthday, household_gender, household_phone,
                household_checkin_time, household_house_type, household_address));
        return selectAllHousehold(request);
    }


    /**
     * 删除住户
     * @param householdId
     * @return
     */
    @RequestMapping("/deleteHouseholdById")
    public String deleteHouseholdById(int householdId,HttpServletRequest request){
        householdInfoService.deleteByHouseholdId(householdId);
        return selectAllHousehold(request);
    }

}
