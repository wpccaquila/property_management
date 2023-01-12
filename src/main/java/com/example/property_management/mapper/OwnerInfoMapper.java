package com.example.property_management.mapper;


import com.example.property_management.pojo.OwnerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OwnerInfoMapper {
    /**
     * 新增一个业主
     * @param ownerInfo
     */
     void addOwner(OwnerInfo ownerInfo);

    /**
     * 姓名查询业主
     * @param ownerName
     * @return
     */
     OwnerInfo queryOwnerByName(
            @Param("owner_name")
            String ownerName);

    /**
     * 通过Id查询业主
     * @param ownerId
     * @return
     */
     OwnerInfo queryOwnerById(
            @Param("owner_id")
            int ownerId);

    /**
     * 查询所有业主
     * @return
     */
    List<OwnerInfo> queryAllOwner();

    /**
     * 修改业主信息
     * 返回1修改成功，返回0修改失败
     * @param ownerInfo
     * @return
     */
     int modifyOwner(OwnerInfo ownerInfo);

    /**
     * 通过id 删除业主信息
     * @param ownerId
     * @return
     */
     int deleteOwnerById(@Param("owner_id")
                         int ownerId);

}
