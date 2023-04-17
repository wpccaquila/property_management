package com.property_management.mapper;
import java.util.List;

import com.property_management.pojo.ComplaintsInfo;
import org.apache.ibatis.annotations.Param;

import com.property_management.pojo.BuildingInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wpcc
* @description 针对表【building_info】的数据库操作Mapper
* @createDate 2023-04-17 18:50:39
* @Entity com.property_management.pojo.BuildingInfo
*/
@Mapper
public interface BuildingInfoMapper {
    /**
     * 通过id号码查询楼房信息
     * @param buildingId
     * @return
     */
    BuildingInfo selectAllByBuildingId(@Param("buildingId") Integer buildingId);

    /**
     * 通过ID号删除楼房信息
     * @param buildingId
     * @return
     */
    int deleteByBuildingId(@Param("buildingId") Integer buildingId);

    /**
     * 通过楼房、单元、房间信息查询
     * @param buildingNum
     * @param unitNum
     * @param roomNum
     * @return
     */
    List<BuildingInfo> selectAllByBuildingNumAndUnitNumAndRoomNum(@Param("buildingNum") String buildingNum, @Param("unitNum") String unitNum, @Param("roomNum") String roomNum);


    /**
     * 添加楼房信息
     * @param buildingInfo
     * @return
     */
    int addAll(BuildingInfo buildingInfo);



    /**
     * 修改信息
     * @return
     */
    int updateBuildingInfo(BuildingInfo buildingInfo);

    /**
     * 返回表记录数
     * @return
     */
    int selectBuildingInfoCount();

    /**
     * 使用Pagehelper 分页
     * @param offset
     * @param pageSize
     * @return
     */
    List<BuildingInfo> getBuildingInfoByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);


}




