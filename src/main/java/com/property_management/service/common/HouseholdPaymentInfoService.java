package com.property_management.service.common;


import com.property_management.pojo.HouseholdInfo;
import com.property_management.pojo.HouseholdPaymentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wpcc
* @description 针对表【household_payment_info】的数据库操作Service
* @createDate 2023-01-28 10:05:19
*/
public interface HouseholdPaymentInfoService {
    /**
     * 通过住户电话查询缴费订单信息
     * @param ownerPhone
     * @return
     */
    List<HouseholdPaymentInfo> selectAllByOwnerPhone(String ownerPhone);


    /**
     * 修改状态为已支付
     * @param paymentStatus
     * @return
     */
    int updatePaymentStatus(@Param("paymentStatus") String paymentStatus,@Param("propertyPaymentId") Integer propertyPaymentId);

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
    HouseholdPaymentInfo selectAllByPropertyPaymentId(Integer propertyPaymentId);

    /**
     * 通过住户名字查询缴费订单信息
     * @param householdName
     * @return
     */
    List<HouseholdPaymentInfo> selectAllByHouseholdName(String householdName);

    /**
     * ID 号删除
     * @param propertyPaymentId
     * @return
     */
    int deleteByPropertyPaymentId(Integer propertyPaymentId);

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


}
