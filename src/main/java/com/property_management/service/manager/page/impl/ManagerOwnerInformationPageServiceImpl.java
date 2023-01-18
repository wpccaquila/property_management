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
        PageHelper.startPage(pageNum, pageSize);
        return ownerInfoMapper.queryAllOwner();
    }
}
