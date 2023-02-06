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
 * @TableName complaints_info
 */
@TableName(value ="complaints_info")
@Data
public class ComplaintsInfo implements Serializable {
    public ComplaintsInfo(Date complaintTime, String complaintContent, String complaintName, String complaintPhone, String complaintStatus) {
        this.complaintTime = complaintTime;
        this.complaintContent = complaintContent;
        this.complaintName = complaintName;
        this.complaintPhone = complaintPhone;
        this.complaintStatus = complaintStatus;
    }

    public ComplaintsInfo() {
    }

    public ComplaintsInfo(Integer complaintId, Date complaintTime, String complaintContent, String complaintName, String complaintPhone, String complaintStatus) {
        this.complaintId = complaintId;
        this.complaintTime = complaintTime;
        this.complaintContent = complaintContent;
        this.complaintName = complaintName;
        this.complaintPhone = complaintPhone;
        this.complaintStatus = complaintStatus;
    }

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer complaintId;

    /**
     * 投诉时间
     */
    private Date complaintTime;

    /**
     * 投诉内容
     */
    private String complaintContent;

    /**
     * 投诉人姓名
     */
    private String complaintName;

    /**
     * 投诉人电话
     */
    private String complaintPhone;

    /**
     * 投诉状态
     */
    private String complaintStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}