package com.property_management.service.common;

import com.property_management.pojo.HouseholdInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wpcc
* @description 针对表【household_info】的数据库操作Service
* @createDate 2023-01-26 11:24:34
*/
public interface HouseholdInfoService {
    /**
     * 增加一个住户
     * @param householdInfo
     * @return
     */
    int addAll(HouseholdInfo householdInfo);

    /**
     * 通过电话号码查询
     * @param ownerPhone
     * @return
     */
    HouseholdInfo selectAllByOwnerPhone( String ownerPhone);



    /**
     * 根据id号删除住户
     * @param householdId
     * @return
     */
    int deleteByHouseholdId(Integer householdId);

    /**
     * 查询所有住户
     * @return
     */
    List<HouseholdInfo> selectAllHousehold();

    /**
     * 根据id号查询
     * @param householdId
     * @return
     */
    HouseholdInfo selectAllByHouseholdId(Integer householdId);

    /**
     * 通过名字查询
     * @param householdName
     * @return
     */
    List<HouseholdInfo> selectAllByHouseholdName(String householdName);


    /**
     * 修改住户信息
     * @param householdInfo
     * @return
     */
    int modifyHousehold(HouseholdInfo householdInfo);

    /**
     * 返回表记录数
     * @return
     */
    int selectHouseholdInfoCount();

    /**
     * 使用Pagehelper 分页
     *
     * @param offset
     * @param pageSize
     * @return
     */
    List<HouseholdInfo> getHouseholdInfoByPage(int offset, int pageSize);

}
