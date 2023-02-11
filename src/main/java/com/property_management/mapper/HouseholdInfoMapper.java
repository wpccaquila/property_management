package com.property_management.mapper;
import java.util.List;

import com.property_management.pojo.OwnerInfo;
import org.apache.ibatis.annotations.Param;

import com.property_management.pojo.HouseholdInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wpcc
* @description 住户信息表的数据持久层
* @createDate 2023-01-26 11:24:34
* @Entity com.property_management.pojo.HouseholdInfo
*/
@Mapper
public interface HouseholdInfoMapper {
    /**
     * 增加一个住户
     * @param householdInfo
     * @return
     */
    int addAll(HouseholdInfo householdInfo);



    /**
     * 根据id号删除住户
     * @param householdId
     * @return
     */
    int deleteByHouseholdId(@Param("householdId") Integer householdId);

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
    HouseholdInfo selectAllByHouseholdId(@Param("householdId") Integer householdId);

    /**
     * 通过名字查询
     * @param ownerName
     * @return
     */
    List<HouseholdInfo> selectAllByHouseholdName(@Param("ownerName") String ownerName);

    /**
     * 通过电话号码查询
     * @param ownerPhone
     * @return
     */
    HouseholdInfo selectAllByOwnerPhone(@Param("ownerPhone") String ownerPhone);


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
     * @param offset
     * @param pageSize
     * @return
     */
    List<HouseholdInfo> getHouseholdInfoByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);


}




