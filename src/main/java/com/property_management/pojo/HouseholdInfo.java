package com.property_management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import javax.persistence.Column;
import lombok.Data;

/**
 * 
 * @TableName household_info
 */
@TableName(value ="household_info")
public class HouseholdInfo implements Serializable {

    public HouseholdInfo(String ownerName, String householdIdNumber, String householdBirthday, String householdGender, String ownerPhone, String householdCheckinTime, String householdHouseType, String householdAddress) {
        this.ownerName = ownerName;
        this.householdIdNumber = householdIdNumber;
        this.householdBirthday = householdBirthday;
        this.householdGender = householdGender;
        this.ownerPhone = ownerPhone;
        this.householdCheckinTime = householdCheckinTime;
        this.householdHouseType = householdHouseType;
        this.householdAddress = householdAddress;
    }

    public HouseholdInfo(Integer householdId, String ownerName, String householdIdNumber, String householdBirthday, String householdGender, String ownerPhone, String householdCheckinTime, String householdHouseType, String householdAddress) {
        this.householdId = householdId;
        this.ownerName = ownerName;
        this.householdIdNumber = householdIdNumber;
        this.householdBirthday = householdBirthday;
        this.householdGender = householdGender;
        this.ownerPhone = ownerPhone;
        this.householdCheckinTime = householdCheckinTime;
        this.householdHouseType = householdHouseType;
        this.householdAddress = householdAddress;
    }

    public HouseholdInfo() {
    }

    @Column(name = "household_id")
    private Integer householdId;

    /**
     * 住户姓名
     */
    @Column(name = "owner_name")
    private String ownerName;

    /**
     * 住户身份证号
     */
    @Column(name = "household_id_number")
    private String householdIdNumber;

    /**
     * 住户出生日期，用于计算年龄等相关信息
     */
    @Column(name = "household_birthday")
    private String householdBirthday;

    /**
     * 住户性别
     */
    @Column(name = "household_gender")
    private String householdGender;

    /**
     * 住户手机号
     */
    @Column(name = "owner_phone")
    private String ownerPhone;

    /**
     * 住户入住时间
     */
    @Column(name = "household_checkin_time")
    private String householdCheckinTime;

    /**
     * 住户户型
     */
    @Column(name = "household_house_type")
    private String householdHouseType;

    /**
     * 住户地址
     */
    @Column(name = "household_address")
    private String householdAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }


    public String getHouseholdIdNumber() {
        return householdIdNumber;
    }

    public void setHouseholdIdNumber(String householdIdNumber) {
        this.householdIdNumber = householdIdNumber;
    }

    public String getHouseholdBirthday() {
        return householdBirthday;
    }

    public void setHouseholdBirthday(String householdBirthday) {
        this.householdBirthday = householdBirthday;
    }

    public String getHouseholdGender() {
        return householdGender;
    }

    public void setHouseholdGender(String householdGender) {
        this.householdGender = householdGender;
    }


    public String getHouseholdCheckinTime() {
        return householdCheckinTime;
    }

    public void setHouseholdCheckinTime(String householdCheckinTime) {
        this.householdCheckinTime = householdCheckinTime;
    }

    public String getHouseholdHouseType() {
        return householdHouseType;
    }

    public void setHouseholdHouseType(String householdHouseType) {
        this.householdHouseType = householdHouseType;
    }

    public String getHouseholdAddress() {
        return householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress;
    }
}