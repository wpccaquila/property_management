package com.property_management.service.common.impl;

import com.property_management.mapper.RepairInfoMapper;
import com.property_management.pojo.RepairInfo;
import com.property_management.service.common.RepairInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author wpcc
* @description 针对表【repair_info】的数据库操作Service实现
* @createDate 2023-02-01 19:53:42
*/
@Service
public class RepairInfoServiceImpl implements RepairInfoService{
    @Resource
    RepairInfoMapper repairInfoMapper;

    @Override
    public int addRepair(RepairInfo repairInfo) {
        return repairInfoMapper.addRepair(repairInfo);
    }

    @Override
    public int deleteByRepairId(Integer repairId) {
        return repairInfoMapper.deleteByRepairId(repairId);
    }

    @Override
    public RepairInfo selectAllByRepairId(Integer repairId) {
        return repairInfoMapper.selectAllByRepairId(repairId);
    }

    @Override
    public List<RepairInfo> selectAll() {
        return repairInfoMapper.selectAll();
    }

    @Override
    public List<RepairInfo> getRepairInfoByPage(int pageNo, int pageSize) {
        return repairInfoMapper.getRepairInfoByPage(pageNo,pageSize);
    }

    @Override
    public List<RepairInfo> queryRepairByType(String repairType) {
        return repairInfoMapper.queryRepairByType(repairType);
    }

    @Override
    public int selectRepairCount() {
        return repairInfoMapper.selectRepairCount();
    }

    @Override
    public int modifyRepairByRepairId(int repairId) {
        return repairInfoMapper.modifyRepairByRepairId(repairId);
    }
}




