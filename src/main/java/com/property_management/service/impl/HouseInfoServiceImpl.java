package com.property_management.service.impl;

import com.property_management.mapper.HouseInfoMapper;
import com.property_management.pojo.HouseInfo;
import com.property_management.service.HouseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseInfoServiceImpl implements HouseInfoService {
    @Resource
    private HouseInfoMapper houseInfoMapper;

    @Override
    public List<HouseInfo> queryAllHouseInfo() {
        return houseInfoMapper.queryAllHouseInfo();
    }

    @Override
    public int insertHouseInfo(HouseInfo houseInfo) {
        return houseInfoMapper.insertAll(houseInfo);
    }

    @Override
    public List<HouseInfo> selectByHouseId(Integer houseId) {
        return houseInfoMapper.selectByHouseId(houseId);
    }

    @Override
    public List<HouseInfo> selectByHouseOwner(String houseOwner) {
        return houseInfoMapper.selectByHouseOwner(houseOwner);
    }

    @Override
    public int updateHouseInfo(HouseInfo houseInfo) {
        return houseInfoMapper.updateHouseInfo(houseInfo);
    }

    @Override
    public int deleteByHouseId(Integer houseId) {
        return houseInfoMapper.deleteByHouseId(houseId);
    }
}
