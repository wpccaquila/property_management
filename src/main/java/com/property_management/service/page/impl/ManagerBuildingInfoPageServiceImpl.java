package com.property_management.service.page.impl;

import com.github.pagehelper.PageHelper;
import com.property_management.mapper.BuildingInfoMapper;
import com.property_management.pojo.BuildingInfo;
import com.property_management.pojo.ComplaintsInfo;
import com.property_management.service.page.ManagerBuildingInfoPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerBuildingInfoPageServiceImpl implements ManagerBuildingInfoPageService {
    @Resource
    BuildingInfoMapper buildingInfoMapper;

    @Override
    public List<BuildingInfo> getBuildingInfoByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return buildingInfoMapper.getBuildingInfoByPage(pageNo, pageSize);
    }

    @Override
    public int getStartLineNo(int pageNo) {
        return pageNo*4;
    }

    @Override
    public int getPageNumber(int pageSize) {
        int totalRows = buildingInfoMapper.selectBuildingInfoCount();
        int pageNumber = totalRows / pageSize;
        // 如果有余数，则将页数加1
        if(totalRows % pageSize != 0){
            pageNumber += 1;
        }
        return pageNumber;
    }
}
