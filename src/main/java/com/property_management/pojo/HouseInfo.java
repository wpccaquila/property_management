package com.property_management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 房屋信息
 * @TableName house_info
 */
@TableName(value ="house_info")
@Data
public class HouseInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer houseId;

    public HouseInfo(String houseName, String houseType, Double houseArea, Integer roomNumber, int houseOwner) {
        this.houseName = houseName;
        this.houseType = houseType;
        this.houseArea = houseArea;
        this.roomNumber = roomNumber;
        this.houseOwner = houseOwner;
    }

    public HouseInfo() {
    }

    public HouseInfo(Integer houseId, String houseName, String houseType, Double houseArea, Integer roomNumber, int houseOwner) {
        this.houseId = houseId;
        this.houseName = houseName;
        this.houseType = houseType;
        this.houseArea = houseArea;
        this.roomNumber = roomNumber;
        this.houseOwner = houseOwner;
    }

    /**
     * 
     */
    private String houseName;

    /**
     * 
     */
    private String houseType;

    /**
     * 
     */
    private Double houseArea;

    /**
     * 
     */
    private Integer roomNumber;

    /**
     * 
     */
    private int houseOwner;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}