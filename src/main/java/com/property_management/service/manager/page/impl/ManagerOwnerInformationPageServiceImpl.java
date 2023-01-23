package com.property_management.service.manager.page.impl;


import com.github.pagehelper.PageHelper;
import com.property_management.mapper.OwnerInfoMapper;
import com.property_management.pojo.OwnerInfo;
import com.property_management.service.manager.page.ManagerOwnerInformationPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ManagerOwnerInformationPageServiceImpl implements ManagerOwnerInformationPageService {
    @Resource
    OwnerInfoMapper ownerInfoMapper;

    public List<OwnerInfo> getOwnerInfoList(Integer pageNum, Integer pageSize){
        return ownerInfoMapper.queryAllOwner();
    }


    @Override
    public List<OwnerInfo> getOwnerInfoByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<OwnerInfo> list = ownerInfoMapper.getOwnerInfoByPage(pageNo, pageSize);
        return list;
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
