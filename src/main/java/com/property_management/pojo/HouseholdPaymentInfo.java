package com.property_management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName household_payment_info
 */
@TableName(value ="household_payment_info")
@Data
public class HouseholdPaymentInfo implements Serializable {

    public HouseholdPaymentInfo(String ownerPhone, String ownerName, String paymentType, BigDecimal paymentAmount, String paymentMethod, Date paymentTime, String paymentStatus) {
        this.ownerPhone = ownerPhone;
        this.ownerName = ownerName;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.paymentStatus = paymentStatus;
    }

    public HouseholdPaymentInfo(Integer propertyPaymentId, String ownerPhone, String ownerName, String paymentType, BigDecimal paymentAmount, String paymentMethod, Date paymentTime, String paymentStatus) {
        this.propertyPaymentId = propertyPaymentId;
        this.ownerPhone = ownerPhone;
        this.ownerName = ownerName;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.paymentStatus = paymentStatus;
    }

    public HouseholdPaymentInfo() {
    }

    /**
     * 物业缴费ID号
     */
    @TableId(type = IdType.AUTO)
    private Integer propertyPaymentId;

    /**
     * 住户ID号
     */
    private String ownerPhone;

    /**
     * 住户姓名
     */
    private String ownerName;

    /**
     * 修改时用的构造对象
     * @param propertyPaymentId
     * @param paymentAmount
     * @param paymentMethod
     * @param paymentTime
     * @param paymentStatus
     */
    public HouseholdPaymentInfo(Integer propertyPaymentId, String paymentType,BigDecimal paymentAmount, String paymentMethod, Date paymentTime, String paymentStatus) {
        this.propertyPaymentId = propertyPaymentId;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.paymentStatus = paymentStatus;
    }

    /**
     * 缴费类型
     */
    private String paymentType;

    /**
     * 缴费金额
     */
    private BigDecimal paymentAmount;

    /**
     * 缴费方式
     */
    private String paymentMethod;

    /**
     * 缴费时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    /**
     * 缴费状态
     */
    private String paymentStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}