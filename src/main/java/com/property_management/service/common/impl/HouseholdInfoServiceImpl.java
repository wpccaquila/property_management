package com.property_management.service.common.impl;

import com.property_management.pojo.HouseholdInfo;
import com.property_management.service.common.HouseholdInfoService;
import com.property_management.mapper.HouseholdInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author wpcc
* @description 针对表【household_info】的数据库操作Service实现
* @createDate 2023-01-26 11:24:34
*/
@Service
public class HouseholdInfoServiceImpl implements HouseholdInfoService{
    @Resource
    HouseholdInfoMapper householdInfoMapper;

    @Override
    public int addAll(HouseholdInfo householdInfo) {
        return householdInfoMapper.addAll(householdInfo);
    }

    @Override
    public HouseholdInfo selectAllByOwnerPhone(String ownerPhone) {
        return householdInfoMapper.selectAllByOwnerPhone(ownerPhone);
    }

    @Override
    public int deleteByHouseholdId(Integer householdId) {
        return householdInfoMapper.deleteByHouseholdId(householdId);
    }

    @Override
    public List<HouseholdInfo> selectAllHousehold() {
        return householdInfoMapper.selectAllHousehold();
    }

    @Override
    public HouseholdInfo selectAllByHouseholdId(Integer householdId) {
        return householdInfoMapper.selectAllByHouseholdId(householdId);
    }

    @Override
    public  List<HouseholdInfo> selectAllByHouseholdName(String householdName) {
        return householdInfoMapper.selectAllByHouseholdName(householdName);
    }

    @Override
    public int modifyHousehold(HouseholdInfo householdInfo) {
        return householdInfoMapper.modifyHousehold(householdInfo);
    }

    @Override
    public int selectHouseholdInfoCount() {
        return householdInfoMapper.selectHouseholdInfoCount();
    }

    @Override
    public List<HouseholdInfo> getHouseholdInfoByPage(int offset, int pageSize) {
        return householdInfoMapper.getHouseholdInfoByPage(offset,pageSize);
    }
}




