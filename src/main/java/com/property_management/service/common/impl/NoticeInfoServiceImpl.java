package com.property_management.service.common.impl;

import com.property_management.mapper.NoticeInfoMapper;
import com.property_management.pojo.HouseholdInfo;
import com.property_management.pojo.NoticeInfo;
import com.property_management.service.common.NoticeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author wpcc
* @description 针对表【notice_info(公告信息表)】的数据库操作Service实现
* @createDate 2023-01-31 20:48:07
*/
@Service
public class NoticeInfoServiceImpl implements NoticeInfoService{

    @Resource
    NoticeInfoMapper noticeInfoMapper;

    @Override
    public List<NoticeInfo> findFourLatestNotice() {
        return noticeInfoMapper.findFourLatestNotice();
    }

    @Override
    public NoticeInfo findLatestNotice() {
        NoticeInfo latestNotice = noticeInfoMapper.findLatestNotice();
//        //将公告内容中空格与回车替换成HTML格式，不然输出到页面时会被忽略
//        String noticeContent = latestNotice.getNoticeContent();
//        noticeContent = noticeContent.replaceAll("\\s", "&nbsp;");//替换空格
//        noticeContent = noticeContent.replaceAll("\r\n", "<br/>");//替换回车
//        System.out.println("输出看看：" + noticeContent);
//        latestNotice.setNoticeContent(noticeContent);
        return latestNotice;
    }

    @Override
    public List<NoticeInfo> selectAll() {
        return noticeInfoMapper.selectAll();
    }

    @Override
    public NoticeInfo selectAllByNoticeId(Integer noticeId) {
        return noticeInfoMapper.selectAllByNoticeId(noticeId);
    }

    @Override
    public int deleteByNoticeId(Integer noticeId) {
        return noticeInfoMapper.deleteByNoticeId(noticeId);
    }

    @Override
    public List<HouseholdInfo> selectAllByNoticeTitleName(String noticeTitle) {
        return noticeInfoMapper.selectAllByNoticeTitleName(noticeTitle);
    }

    @Override
    public int modifyNoticeInfo(NoticeInfo noticeInfo) {
        return noticeInfoMapper.modifyNoticeInfo(noticeInfo);
    }

    @Override
    public int addAll(NoticeInfo noticeInfo) {
        return noticeInfoMapper.addAll(noticeInfo);
    }

    @Override
    public int selectNoticeInfoCount() {
        return noticeInfoMapper.selectNoticeInfoCount();
    }

    @Override
    public List<NoticeInfo> getHouseNoticeInfoByPage(int pageNo, int pageSize) {
        return noticeInfoMapper.getHouseNoticeInfoByPage(pageNo,pageSize);
    }
}




