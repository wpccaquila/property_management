package com.property_management.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 公告信息表
 * @TableName notice_info
 */
@TableName(value ="notice_info")
@Data
public class NoticeInfo implements Serializable {
    public NoticeInfo(String noticeTitle, String noticeContent, Date noticeCreateTime, String noticeCreateUser) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeCreateTime = noticeCreateTime;
        this.noticeCreateUser = noticeCreateUser;
    }

    public NoticeInfo(Integer noticeId, String noticeTitle, String noticeContent, Date noticeCreateTime, String noticeCreateUser) {
        this.noticeId = noticeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeCreateTime = noticeCreateTime;
        this.noticeCreateUser = noticeCreateUser;
    }

    public NoticeInfo() {
    }

    /**
     * 公告id
     */
    @TableId(type = IdType.AUTO)
    private Integer noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 发布时间
     */
    private Date noticeCreateTime;

    /**
     * 发布人
     */
    private String noticeCreateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}