package com.example.property_management.service.impl;


import com.example.property_management.mapper.OwnerInfoMapper;
import com.example.property_management.pojo.OwnerInfo;
import com.example.property_management.service.OwnerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OwnerInfoServiceImpl implements OwnerInfoService {
    @Resource
    private OwnerInfoMapper ownerInfoMapper;

    /**
     * 实现添加一个业主信息
     */
    @Override
    public void addOwner(OwnerInfo ownerInfo) {
        ownerInfoMapper.addOwner(ownerInfo);
    }

    @Override
    public OwnerInfo queryOwnerByName(String ownerName) {
        return ownerInfoMapper.queryOwnerByName(ownerName);
    }

    @Override
    public OwnerInfo queryOwnerById(int ownerId) {
        return ownerInfoMapper.queryOwnerById(ownerId);
    }

    /**
     * 查询所有业主信息
     * @return
     */
    @Override
    public List<OwnerInfo> queryAllOwner() {
        return ownerInfoMapper.queryAllOwner();
    }

    @Override
    public int updataOwnerById(OwnerInfo ownerInfo) {
        return ownerInfoMapper.modifyOwner(ownerInfo);
    }

    @Override
    public int deleteOwnerById(int ownerId) {
        return ownerInfoMapper.deleteOwnerById(ownerId);
    }
}
