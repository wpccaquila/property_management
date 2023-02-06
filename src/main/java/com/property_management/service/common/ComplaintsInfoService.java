package com.property_management.service.common;

import com.property_management.pojo.ComplaintsInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wpcc
* @description 针对表【complaints_info】的数据库操作Service
* @createDate 2023-02-06 10:29:39
*/
public interface ComplaintsInfoService {

    /**
     * 通过ID号查询
     * @param complaintId
     * @return
     */
    ComplaintsInfo selectAllByComplaintId(Integer complaintId);

    /**
     * 通过ID号删除
     * @param complaintId
     * @return
     */
    int deleteByComplaintId(Integer complaintId);

    /**
     * 通过投诉人名字查询
     * @param complaintName
     * @return
     */
    List<ComplaintsInfo> selectAllByComplaintName(String complaintName);

    /**
     * 增加投诉信息
     * @param complaintsInfo
     * @return
     */
    int addAll(ComplaintsInfo complaintsInfo);

    /**
     * 修改
     * @param complaintsInfo
     * @return
     */
    int updateComplaintInfo(ComplaintsInfo complaintsInfo);

    /**
     * 返回表记录数
     * @return
     */
    int selectComplaintInfoCount();

    /**
     * 使用Pagehelper 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<ComplaintsInfo> getComplaintInfoByPage(int pageNo, int pageSize);


}
