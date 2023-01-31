package com.property_management.service.common.impl;

import com.property_management.mapper.HouseholdPaymentInfoMapper;
import com.property_management.pojo.HouseholdInfo;
import com.property_management.pojo.HouseholdPaymentInfo;
import com.property_management.service.common.HouseholdPaymentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author wpcc
* @description 针对表【household_payment_info】的数据库操作Service实现
* @createDate 2023-01-28 10:05:19
*/
@Service
public class HouseholdPaymentInfoServiceImpl implements HouseholdPaymentInfoService {

    @Resource
    HouseholdPaymentInfoMapper householdPaymentInfoMapper;

    @Override
    public List<HouseholdPaymentInfo> selectAll() {
        return householdPaymentInfoMapper.selectAll();
    }

    @Override
    public HouseholdPaymentInfo selectAllByPropertyPaymentId(Integer propertyPaymentId) {
        return householdPaymentInfoMapper.selectAllByPropertyPaymentId(propertyPaymentId);
    }

    @Override
    public List<HouseholdPaymentInfo> selectAllByHouseholdName(String householdName) {
        return householdPaymentInfoMapper.selectAllByHouseholdName(householdName);
    }

    @Override
    public int deleteByPropertyPaymentId(Integer propertyPaymentId) {
        return householdPaymentInfoMapper.deleteByPropertyPaymentId(propertyPaymentId);
    }

    @Override
    public int modifyHouseholdPaymentInfo(HouseholdPaymentInfo householdPaymentInfo) {
        return householdPaymentInfoMapper.modifyHouseholdPaymentInfo(householdPaymentInfo);
    }

    @Override
    public int addAll(HouseholdPaymentInfo householdPaymentInfo) {
        return householdPaymentInfoMapper.addAll(householdPaymentInfo);
    }

    @Override
    public int selectHouseholdPaymentInfoCount() {
        return householdPaymentInfoMapper.selectHouseholdPaymentInfoCount();
    }

}




