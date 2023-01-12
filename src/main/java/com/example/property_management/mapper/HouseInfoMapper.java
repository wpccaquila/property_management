package com.example.property_management.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.property_management.pojo.HouseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wpcc
* @description 针对表【house_info】的数据库操作Mapper
* @createDate 2023-01-10 11:01:53
* @Entity com.example.property_management.pojo.HouseInfo
*/
@Mapper
public interface HouseInfoMapper extends BaseMapper<HouseInfo> {

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
    int insertAll(HouseInfo houseInfo);

    /**
     * 根据房屋id号查询房屋信息
     * @param houseId
     * @return
     */
    List<HouseInfo> selectByHouseId(@Param("houseId") Integer houseId);

    /**
     * 根据业主姓名查询房屋信息
     * @param houseOwner
     * @return
     */
    List<HouseInfo> selectByHouseOwner(@Param("houseOwner") String houseOwner);

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
    int deleteByHouseId(@Param("houseId") Integer houseId);


}




