package com.property_management.service.common.impl;

import com.property_management.mapper.ComplaintsInfoMapper;
import com.property_management.pojo.ComplaintsInfo;
import com.property_management.service.common.ComplaintsInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author wpcc
* @description 针对表【complaints_info】的数据库操作Service实现
* @createDate 2023-02-06 10:29:39
*/
@Service
public class ComplaintsInfoServiceImpl implements ComplaintsInfoService{
    @Resource
    ComplaintsInfoMapper complaintsInfoMapper;

    @Override
    public ComplaintsInfo selectAllByComplaintId(Integer complaintId) {
        return complaintsInfoMapper.selectAllByComplaintId(complaintId);
    }

    @Override
    public int deleteByComplaintId(Integer complaintId) {
        return complaintsInfoMapper.deleteByComplaintId(complaintId);
    }

    @Override
    public List<ComplaintsInfo> selectAllByOwnerPhone(String ownerPhone) {
        return complaintsInfoMapper.selectAllByOwnerPhone(ownerPhone);
    }

    @Override
    public List<ComplaintsInfo> selectAllByComplaintName(String ownerName) {
        return complaintsInfoMapper.selectAllByComplaintName(ownerName);
    }

    @Override
    public int addAll(ComplaintsInfo complaintsInfo) {
        return complaintsInfoMapper.addAll(complaintsInfo);
    }

    @Override
    public int updateComplaintInfo(ComplaintsInfo complaintsInfo) {
        return complaintsInfoMapper.updateComplaintInfo(complaintsInfo);
    }

    @Override
    public int selectComplaintInfoCount() {
        return complaintsInfoMapper.selectComplaintInfoCount();
    }

    @Override
    public List<ComplaintsInfo> getComplaintInfoByPage(int pageNo, int pageSize) {
        return complaintsInfoMapper.getComplaintInfoByPage(pageNo,pageSize);
    }
}




