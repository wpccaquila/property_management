package com.property_management.service.page.impl;


import com.github.pagehelper.PageHelper;
import com.property_management.mapper.NoticeInfoMapper;
import com.property_management.service.page.ManagerNoticeInfoPageService;
import org.springframework.stereotype.Service;
import com.property_management.pojo.NoticeInfo;
import javax.annotation.Resource;
import java.util.List;


@Service
public class ManagerNoticePageServiceImpl implements ManagerNoticeInfoPageService {
    @Resource
    NoticeInfoMapper noticeInfoMapper;

    @Override
    public List<NoticeInfo> getNoticeInfoByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return noticeInfoMapper.getHouseNoticeInfoByPage(pageNo, pageSize);
    }

    @Override
    public int getStartLineNo(int pageNo) {
        return pageNo*4;
    }

    @Override
    public int getPageNumber(int pageSize) {
        int totalRows = noticeInfoMapper.selectNoticeInfoCount();
        int pageNumber = totalRows / pageSize;
        // 如果有余数，则将页数加1
        if(totalRows % pageSize != 0){
            pageNumber += 1;
        }
        return pageNumber;
    }


}
