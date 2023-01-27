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
    public HouseholdInfo() {
    }

    public HouseholdInfo(String householdName, String householdIdNumber, String householdBirthday, String householdGender, Integer householdPhone, String householdCheckinTime, String householdHouseType, String householdAddress) {
        this.householdName = householdName;
        this.householdIdNumber = householdIdNumber;
        this.householdBirthday = householdBirthday;
        this.householdGender = householdGender;
        this.householdPhone = householdPhone;
        this.householdCheckinTime = householdCheckinTime;
        this.householdHouseType = householdHouseType;
        this.householdAddress = householdAddress;
    }

    public HouseholdInfo(Integer householdId, String householdName, String householdIdNumber, String householdBirthday, String householdGender, Integer householdPhone, String householdCheckinTime, String householdHouseType, String householdAddress) {
        this.householdId = householdId;
        this.householdName = householdName;
        this.householdIdNumber = householdIdNumber;
        this.householdBirthday = householdBirthday;
        this.householdGender = householdGender;
        this.householdPhone = householdPhone;
        this.householdCheckinTime = householdCheckinTime;
        this.householdHouseType = householdHouseType;
        this.householdAddress = householdAddress;
    }


    @Column(name = "household_id")
    private Integer householdId;

    /**
     * 住户姓名
     */
    @Column(name = "household_name")
    private String householdName;

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
    @Column(name = "household_phone")
    private Integer householdPhone;

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

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public String getHouseholdName() {
        return householdName;
    }

    public void setHouseholdName(String householdName) {
        this.householdName = householdName;
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

    public Integer getHouseholdPhone() {
        return householdPhone;
    }

    public void setHouseholdPhone(Integer householdPhone) {
        this.householdPhone = householdPhone;
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