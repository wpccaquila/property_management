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
    public HouseholdPaymentInfo(Integer householdId, String householdName, BigDecimal paymentAmount, String paymentMethod, Date paymentTime, String paymentStatus) {
        this.householdId = householdId;
        this.householdName = householdName;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.paymentStatus = paymentStatus;
    }

    public HouseholdPaymentInfo() {
    }

    public HouseholdPaymentInfo(Integer propertyPaymentId, Integer householdId, String householdName, BigDecimal paymentAmount, String paymentMethod, Date paymentTime, String paymentStatus) {
        this.propertyPaymentId = propertyPaymentId;
        this.householdId = householdId;
        this.householdName = householdName;
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.paymentStatus = paymentStatus;
    }

    /**
     * 物业缴费ID号
     */
    @TableId(type = IdType.AUTO)
    private Integer propertyPaymentId;

    /**
     * 住户ID号
     */
    private Integer householdId;

    /**
     * 住户姓名
     */
    private String householdName;

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