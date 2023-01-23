package com.property_management.mapper;


import com.property_management.pojo.OwnerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OwnerInfoMapper {
    /**
     * 新增一个业主
     * @param ownerInfo
     */
     int addOwner(OwnerInfo ownerInfo);

    /**
     * 重新排序id
     */
    void orderId();

    /**
     * 使用Pagehelper 分页
     * @param offset
     * @param pageSize
     * @return
     */
    List<OwnerInfo> getOwnerInfoByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 通过手机号和密码返回业主信息
     * @param owner_phone
     * @param owner_password
     * @return
     */
    OwnerInfo selectByOwner_phoneAndOwner_password(@Param("owner_phone") int owner_phone, @Param("owner_password") String owner_password);

    /**
     * 姓名查询业主
     * @param ownerName
     * @return
     */
     List<OwnerInfo> queryOwnerByName(
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
     * 返回表记录数
     * @return
     */
    int selectCount();

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
