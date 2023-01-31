package com.property_management.service.manager.page.impl;


import com.github.pagehelper.PageHelper;
import com.property_management.mapper.HouseholdInfoMapper;
import com.property_management.pojo.HouseholdInfo;
import com.property_management.service.manager.page.ManagerHouseholdInfoPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ManagerHouseholdInfoPageServiceImpl implements ManagerHouseholdInfoPageService {
    @Resource
    HouseholdInfoMapper householdInfoMapper;

    @Override
    public List<HouseholdInfo> getHouseholdInfoByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return householdInfoMapper.getHouseholdInfoByPage(pageNo, pageSize);
    }

    @Override
    public int getStartLineNo(int pageNo) {
        return pageNo*4;
    }

    @Override
    public int getPageNumber(int pageSize) {
        int totalRows = householdInfoMapper.selectCount();
        int pageNumber = totalRows / pageSize;
        // 如果有余数，则将页数加1
        if(totalRows % pageSize != 0){
            pageNumber += 1;
        }
        return pageNumber;
    }


}
