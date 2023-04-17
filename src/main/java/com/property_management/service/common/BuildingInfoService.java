package com.property_management.service.common;


import com.property_management.pojo.BuildingInfo;

import java.util.List;

/**
* @author wpcc
* @description 针对表【building_info】的数据库操作Service
* @createDate 2023-04-17 18:50:39
*/
public interface BuildingInfoService {

    /**
     * 通过id号码查询楼房信息
     * @param buildingId
     * @return
     */
    BuildingInfo selectAllByBuildingId(Integer buildingId);

    /**
     * 通过ID号删除楼房信息
     * @param buildingId
     * @return
     */
    int deleteByBuildingId(Integer buildingId);

    /**
     * 通过楼房、单元、房间信息查询
     * @param buildingNum
     * @param unitNum
     * @param roomNum
     * @return
     */
    List<BuildingInfo> selectAllByBuildingNumAndUnitNumAndRoomNum( String buildingNum, String unitNum, String roomNum);


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
     *
     * @param offset
     * @param pageSize
     * @return
     */
    List<BuildingInfo> getBuildingInfoByPage(int offset, int pageSize);

}
