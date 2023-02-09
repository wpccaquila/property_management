package com.property_management.mapper;
import java.util.List;

import com.property_management.pojo.OwnerInfo;
import org.apache.ibatis.annotations.Param;

import com.property_management.pojo.RepairInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wpcc
* @description 针对表【repair_info】的数据库操作Mapper
* @createDate 2023-02-01 19:53:42
* @Entity com.property_management.pojo.RepairInfo
*/
@Mapper
public interface RepairInfoMapper {
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
    int deleteByRepairId(@Param("repairId") Integer repairId);

    /**
     * ID 查询报修信息
     * @param repairId
     * @return
     */
    RepairInfo selectAllByRepairId(@Param("repairId") Integer repairId);

    /**
     * 查询所有信息
     * @return
     */
    List<RepairInfo> selectAll();

    /**
     * 使用Pagehelper 分页
     * @param offset
     * @param pageSize
     * @return
     */
    List<RepairInfo> getRepairInfoByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 通过报修类别查询
     * @param repairType
     * @return
     */
    List<RepairInfo> queryRepairByType(
            @Param("repair_type")
            String repairType);

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
    List<RepairInfo> searchAllByRepairType(@Param("ownerName") String ownerName);

}




