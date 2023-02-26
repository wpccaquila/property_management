package com.property_management.mapper;
import java.util.Date;
import java.util.List;

import com.property_management.pojo.HouseholdInfo;
import org.apache.ibatis.annotations.Param;

import com.property_management.pojo.ComplaintsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wpcc
* @description 针对表【complaints_info】的数据库操作Mapper
* @createDate 2023-02-06 10:29:39
* @Entity com.property_management.pojo.ComplaintsInfo
*/
@Mapper
public interface ComplaintsInfoMapper {
    /**
     * 通过ID号查询
     * @param complaintId
     * @return
     */
    ComplaintsInfo selectAllByComplaintId(@Param("complaintId") Integer complaintId);

    /**
     * 修改用户评价
     * @param userEvaluation
     * @param complaintId
     * @return
     */
    int modifyUserEvaluationByComplaintId(@Param("userEvaluation") String userEvaluation, @Param("complaintId") Integer complaintId);

    /**
     * 通过ID号删除
     * @param complaintId
     * @return
     */
    int deleteByComplaintId(@Param("complaintId") Integer complaintId);

    /**
     * 通过投诉人名字查询
     * @param ownerName
     * @return
     */
    List<ComplaintsInfo> selectAllByComplaintName(@Param("ownerName") String ownerName);

    /**
     * 通过电话查询投诉信息
     * @param ownerPhone
     * @return
     */
    List<ComplaintsInfo> selectAllByOwnerPhone(@Param("ownerPhone") String ownerPhone);

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
     * @param offset
     * @param pageSize
     * @return
     */
    List<ComplaintsInfo> getComplaintInfoByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);


}




