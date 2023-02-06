package com.property_management.service.manager.page.impl;

import com.github.pagehelper.PageHelper;
import com.property_management.mapper.ComplaintsInfoMapper;
import com.property_management.pojo.ComplaintsInfo;
import com.property_management.service.manager.page.ManagerComplaintsInfoPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerComplaintsInfoPageServiceImpl implements ManagerComplaintsInfoPageService {
    @Resource
    ComplaintsInfoMapper complaintsInfoMapper;


    @Override
    public List<ComplaintsInfo> getComplaintsInfoByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return complaintsInfoMapper.getComplaintInfoByPage(pageNo, pageSize);
    }

    @Override
    public int getStartLineNo(int pageNo) {
        return pageNo*4;
    }

    @Override
    public int getPageNumber(int pageSize) {
        int totalRows = complaintsInfoMapper.selectComplaintInfoCount();
        int pageNumber = totalRows / pageSize;
        // 如果有余数，则将页数加1
        if(totalRows % pageSize != 0){
            pageNumber += 1;
        }
        return pageNumber;
    }


}
