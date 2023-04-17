package com.property_management.service.common.impl;


import com.property_management.mapper.BuildingInfoMapper;
import com.property_management.pojo.BuildingInfo;
import com.property_management.service.common.BuildingInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author wpcc
* @description 针对表【building_info】的数据库操作Service实现
* @createDate 2023-04-17 18:50:39
*/
@Service
public class BuildingInfoServiceImpl implements BuildingInfoService{

    @Resource
    BuildingInfoMapper buildingInfoMapper;

    @Override
    public BuildingInfo selectAllByBuildingId(Integer buildingId) {
        return buildingInfoMapper.selectAllByBuildingId(buildingId);
    }

    @Override
    public int deleteByBuildingId(Integer buildingId) {
        return buildingInfoMapper.deleteByBuildingId(buildingId);
    }

    @Override
    public List<BuildingInfo> selectAllByBuildingNumAndUnitNumAndRoomNum(String buildingNum, String unitNum, String roomNum) {
        return buildingInfoMapper.selectAllByBuildingNumAndUnitNumAndRoomNum(buildingNum,unitNum,roomNum);
    }

    @Override
    public int addAll(BuildingInfo buildingInfo) {
        return buildingInfoMapper.addAll(buildingInfo);
    }

    @Override
    public int updateBuildingInfo(BuildingInfo buildingInfo) {
        return buildingInfoMapper.updateBuildingInfo(buildingInfo);
    }

    @Override
    public int selectBuildingInfoCount() {
        return buildingInfoMapper.selectBuildingInfoCount();
    }

    @Override
    public List<BuildingInfo> getBuildingInfoByPage(int offset, int pageSize) {
        return buildingInfoMapper.getBuildingInfoByPage(offset,pageSize);
    }
}




