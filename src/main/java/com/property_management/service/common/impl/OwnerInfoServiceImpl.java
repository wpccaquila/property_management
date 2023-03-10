package com.property_management.service.common.impl;


import com.property_management.mapper.OwnerInfoMapper;
import com.property_management.pojo.OwnerInfo;
import com.property_management.service.common.OwnerInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OwnerInfoServiceImpl implements OwnerInfoService {
    @Resource
    private OwnerInfoMapper ownerInfoMapper;

    @Override
    public int addOwner(OwnerInfo ownerInfo) {
        return ownerInfoMapper.addOwner(ownerInfo);
    }

    @Override
    public List<OwnerInfo> queryOwnerByName(String ownerName) {
        return ownerInfoMapper.queryOwnerByName(ownerName);
    }


    @Override
    public OwnerInfo queryOwnerById(int ownerId) {
        return ownerInfoMapper.queryOwnerById(ownerId);
    }

    @Override
    public OwnerInfo queryOwnerByPhoneAndPassword(String phone, String password) {
        return ownerInfoMapper.selectByOwner_phoneAndOwner_password(phone,password);
    }

    @Override
    public OwnerInfo selectByOwner_phone(String owner_phone) {
        return ownerInfoMapper.selectByOwner_phone(owner_phone);
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
    public int updateOwnerById(OwnerInfo ownerInfo) {
        return ownerInfoMapper.modifyOwner(ownerInfo);
    }

    @Override
    public int deleteOwnerById(int ownerId) {
        return ownerInfoMapper.deleteOwnerById(ownerId);
    }
}
