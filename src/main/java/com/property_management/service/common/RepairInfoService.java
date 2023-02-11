package com.property_management.service.common;


import com.property_management.pojo.RepairInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wpcc
* @description 针对表【repair_info】的数据库操作Service
* @createDate 2023-02-01 19:53:42
*/
public interface RepairInfoService {

    /**
     * 通过电话查询
     * @param ownerPhone
     * @return
     */
    List<RepairInfo> selectAllByOwnerPhone( String ownerPhone);
    /**
     * 添加报修信息
     * @param repairInfo
     * @return
     */
    int addRepair(RepairInfo repairInfo);

    /**
     * ID 删除报修信息
     * @param repairId
     * @return
     */
    int deleteByRepairId(Integer repairId);

    /**
     * ID 查询报修信息
     * @param repairId
     * @return
     */
    RepairInfo selectAllByRepairId(Integer repairId);

    /**
     * 查询所有信息
     * @return
     */
    List<RepairInfo> selectAll();

    /**
     * 使用Pagehelper 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<RepairInfo> getRepairInfoByPage(int pageNo,int pageSize);

    /**
     * 通过报修类别查询
     * @param repairType
     * @return
     */
    List<RepairInfo> queryRepairByType(String repairType);

    /**
     * 返回表记录数
     * @return
     */
    int selectRepairCount();

    /**
     * 修改报修信息
     * @return
     */
    int modifyRepairByRepairId(RepairInfo repairInfo);

    /**
     * 通过报修类型查询
     * @param ownerName
     * @return
     */
    List<RepairInfo> searchAllByOwnerName(@Param("ownerName") String ownerName);

}
