package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;


/**
 * 岗位表 sys_post
 * 
 * @author ruoyi
 */

@Data
@TableName("sys_order")
public class SysOrder
{
    @TableId(value ="order_id",type = IdType.AUTO)
    private Long orderId;

    @TableField("order_type")
    private String orderType;

    @TableField("order_content")
    private String orderContent;

    @TableField("order_status")
    private String orderStatus;

    @TableField("company")
    private String company;

    @TableField("create_by")
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @TableField("update_by")
    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private Date updateTime;

    @TableField("remark")
    private String remark;

    @TableField(exist = false)
    private String startTime;

    @TableField(exist = false)
    private String endTime;

}
