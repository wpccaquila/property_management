package com.property_management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName repair_info
 */
@TableName(value ="repair_info")
@Data
public class RepairInfo implements Serializable {
    public RepairInfo(String repairType, String repairContent, Date repairCreateTime, String repairApplicant, String repairState, String repairProcessor) {
        this.repairType = repairType;
        this.repairContent = repairContent;
        this.repairCreateTime = repairCreateTime;
        this.repairApplicant = repairApplicant;
        this.repairState = repairState;
        this.repairProcessor = repairProcessor;
    }

    public RepairInfo(Integer repairId, String repairType, String repairContent, Date repairCreateTime, String repairApplicant, String repairState, String repairProcessor) {
        this.repairId = repairId;
        this.repairType = repairType;
        this.repairContent = repairContent;
        this.repairCreateTime = repairCreateTime;
        this.repairApplicant = repairApplicant;
        this.repairState = repairState;
        this.repairProcessor = repairProcessor;
    }

    public RepairInfo() {
    }

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer repairId;

    /**
     * 报修类型
     */
    private String repairType;

    /**
     * 报修内容
     */
    private String repairContent;

    /**
     * 报修时间
     */
    private Date repairCreateTime;

    /**
     * 报修人
     */
    private String repairApplicant;

    /**
     * 维修状态
     */
    private String repairState;

    /**
     * 维修人
     */
    private String repairProcessor;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}