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

    public ComplaintsInfo() {
    }

    public ComplaintsInfo(Date complaintTime, String complaintContent, String ownerName, String ownerPhone, String complaintStatus, String processingContent, String userEvaluation, Date processingDate) {
        this.complaintTime = complaintTime;
        this.complaintContent = complaintContent;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.complaintStatus = complaintStatus;
        this.processingContent = processingContent;
        this.userEvaluation = userEvaluation;
        this.processingDate = processingDate;
    }

    public ComplaintsInfo(Integer complaintId, Date complaintTime, String complaintContent, String ownerName, String ownerPhone, String complaintStatus, String processingContent, String userEvaluation, Date processingDate) {
        this.complaintId = complaintId;
        this.complaintTime = complaintTime;
        this.complaintContent = complaintContent;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.complaintStatus = complaintStatus;
        this.processingContent = processingContent;
        this.userEvaluation = userEvaluation;
        this.processingDate = processingDate;
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
    private String ownerName;


    /**
     * 投诉人电话
     */
    private String ownerPhone;

    /**
     * 投诉状态
     */
    private String complaintStatus;

    /**
     * 处理内容
     */
    private String processingContent;


    /**
     * 用户评价反馈
     */
    private String userEvaluation;

    /**
     * 处理日期
     */
    private Date processingDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}