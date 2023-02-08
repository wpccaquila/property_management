package com.property_management.service.common;

import com.property_management.pojo.HouseholdInfo;
import com.property_management.pojo.HouseholdPaymentInfo;
import com.property_management.pojo.NoticeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wpcc
* @description 针对表【notice_info(公告信息表)】的数据库操作Service
* @createDate 2023-01-31 20:48:07
*/
public interface NoticeInfoService {

    /**
     * 返回最后四条公告
     * @return
     */
    List<NoticeInfo> findFourLatestNotice();

    /**
     * 返回最新一条公告信息
     * @return
     */
    NoticeInfo findLatestNotice();


    /**
     * 返回所有数据
     * @return
     */
    List<NoticeInfo> selectAll();

    /**
     * Id号查询
     * @param noticeId
     * @return
     */
    NoticeInfo selectAllByNoticeId(Integer noticeId);

    /**
     * ID号删除
     * @param noticeId
     * @return
     */
    int deleteByNoticeId(Integer noticeId);

    /**
     * 通过标题查询
     * @param noticeTitle
     * @return
     */
    List<HouseholdInfo> selectAllByNoticeTitleName(String noticeTitle);

    /**
     * 修改公告信息
     * @param noticeInfo
     * @return
     */
    int modifyNoticeInfo(NoticeInfo noticeInfo);

    /**
     * 添加公告
     * @param noticeInfo
     * @return
     */
    int addAll(NoticeInfo noticeInfo);

    /**
     * 返回表记录数
     * @return
     */
    int selectNoticeInfoCount();

    /**
     * 使用Pagehelper 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<NoticeInfo> getHouseNoticeInfoByPage(int pageNo,int pageSize);


}
