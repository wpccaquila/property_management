package com.property_management.service.page.impl;


import com.github.pagehelper.PageHelper;
import com.property_management.mapper.HouseholdPaymentInfoMapper;
import com.property_management.pojo.HouseholdPaymentInfo;
import com.property_management.service.page.ManagerHouseholdPaymentInfoPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ManagerHouseholdPaymentInfoPageServiceImpl implements ManagerHouseholdPaymentInfoPageService {
    @Resource
    HouseholdPaymentInfoMapper householdPaymentInfoMapper;

    @Override
    public List<HouseholdPaymentInfo> getHouseholdPaymentInfoByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return householdPaymentInfoMapper.getHouseholdPaymentInfoByPage(pageNo,pageSize);
    }


    @Override
    public int getStartLineNo(int pageNo) {
        return pageNo*4;
    }

    @Override
    public int getPageNumber(int pageSize) {
        int totalRows = householdPaymentInfoMapper.selectHouseholdPaymentInfoCount();
        int pageNumber = totalRows / pageSize;
        // 如果有余数，则将页数加1
        if(totalRows % pageSize != 0){
            pageNumber += 1;
        }
        return pageNumber;
    }


}
