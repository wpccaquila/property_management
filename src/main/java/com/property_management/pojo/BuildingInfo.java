package com.property_management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName building_info
 */
@TableName(value ="building_info")
@Data
public class BuildingInfo implements Serializable {
    public BuildingInfo(Integer buildingId, String buildingNum, String unitNum, String roomNum, String ownerName, String ownerPhone) {
        this.buildingId = buildingId;
        this.buildingNum = buildingNum;
        this.unitNum = unitNum;
        this.roomNum = roomNum;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
    }

    public BuildingInfo(Integer buildingId, String buildingNum, String unitNum, String roomNum) {
        this.buildingId = buildingId;
        this.buildingNum = buildingNum;
        this.unitNum = unitNum;
        this.roomNum = roomNum;
    }

    public BuildingInfo() {
    }

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer buildingId;

    /**
     * 
     */
    private String buildingNum;

    /**
     * 
     */
    private String unitNum;

    /**
     * 
     */
    private String roomNum;

    /**
     * 
     */
    private String ownerName;

    /**
     * 
     */
    private String ownerPhone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}