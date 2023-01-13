package com.property_management.service.common;

import com.property_management.pojo.HouseInfo;

import java.util.List;

public interface HouseInfoService {
    /**
     * 查询所有房屋信息
     * @return
     */
    List<HouseInfo> queryAllHouseInfo();

    /**
     * 插入房屋信息
     * @param houseInfo
     * @return
     */
    int insertHouseInfo(HouseInfo houseInfo);

    /**
     * 根据房屋id号查询房屋信息
     * @param houseId
     * @return
     */
    List<HouseInfo> selectByHouseId(Integer houseId);

    /**
     * 根据业主姓名查询房屋信息
     * @param houseOwner
     * @return
     */
    List<HouseInfo> selectByHouseOwner(String houseOwner);

    /**
     * 修改用户信息
     * @param houseInfo
     * @return
     */
    int updateHouseInfo(HouseInfo houseInfo);

    /**
     * 通过id号删除房屋信息
     * @param houseId
     * @return
     */
    int deleteByHouseId(Integer houseId);

}
