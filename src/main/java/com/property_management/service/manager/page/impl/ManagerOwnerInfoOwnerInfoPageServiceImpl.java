package com.property_management.service.manager.page.impl;


import com.github.pagehelper.PageHelper;
import com.property_management.mapper.HouseholdInfoMapper;
import com.property_management.mapper.OwnerInfoMapper;
import com.property_management.pojo.OwnerInfo;
import com.property_management.service.manager.page.ManagerOwnerInfoPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ManagerOwnerInfoOwnerInfoPageServiceImpl implements ManagerOwnerInfoPageService {
    @Resource
    OwnerInfoMapper ownerInfoMapper;



    @Override
    public List<OwnerInfo> getOwnerInfoByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return ownerInfoMapper.getOwnerInfoByPage(pageNo, pageSize);
    }

    @Override
    public int getStartLineNo(int pageNo) {
        return pageNo*4;
    }

    @Override
    public int getPageNumber(int pageSize) {
        int totalRows = ownerInfoMapper.selectCount();
        int pageNumber = totalRows / pageSize;
        // 如果有余数，则将页数加1
        if(totalRows % pageSize != 0){
            pageNumber += 1;
        }
        return pageNumber;
    }


}
