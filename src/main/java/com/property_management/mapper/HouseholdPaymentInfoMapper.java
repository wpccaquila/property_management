package com.property_management.mapper;
import com.property_management.pojo.HouseholdInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.property_management.pojo.HouseholdPaymentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wpcc
* @description 针对表【household_payment_info】的数据库操作Mapper
* @createDate 2023-01-28 10:05:19
* @Entity com.property_management.pojo.HouseholdPaymentInfo
*/
@Mapper
public interface HouseholdPaymentInfoMapper {

    /**
     * 返回所有数据
     * @return
     */
    List<HouseholdPaymentInfo> selectAll();

    /**
     * ID号查询
     * @param propertyPaymentId
     * @return
     */
    List<HouseholdPaymentInfo> selectAllByPropertyPaymentId(@Param("propertyPaymentId") Integer propertyPaymentId);

    /**
     * 通过住户名字查询缴费订单信息
     * @param householdName
     * @return
     */
    List<HouseholdPaymentInfo> selectAllByHouseholdName(@Param("householdName") String householdName);

    /**
     * ID 号删除
     * @param propertyPaymentId
     * @return
     */
    int deleteByPropertyPaymentId(@Param("propertyPaymentId") Integer propertyPaymentId);

    /**
     * 修改缴费信息
     * @param householdPaymentInfo
     * @return
     */
    int modifyHouseholdPaymentInfo(HouseholdPaymentInfo householdPaymentInfo);

    /**
     * 增加缴费订单
     * @param householdPaymentInfo
     * @return
     */
    int addAll(HouseholdPaymentInfo householdPaymentInfo);

    /**
     * 返回表记录数
     * @return
     */
    int selectHouseholdPaymentInfoCount();

    /**
     * 使用Pagehelper 分页
     * @param offset
     * @param pageSize
     * @return
     */
    List<HouseholdInfo> getHouseholdPaymentInfoByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);


}




