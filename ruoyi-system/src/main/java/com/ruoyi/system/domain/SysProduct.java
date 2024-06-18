package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;


/**
 * 岗位表 sys_post
 * 
 * @author ruoyi
 */

@Data
@TableName("sys_product")
public class SysProduct extends BaseEntity
{
    @TableId(value ="product_id",type = IdType.AUTO)
    private Long productId;

    @TableField("product_name")
    private String productName;

    @TableField("product_price")
    private String productPrice;

    @TableField("product_type")
    private String productType;

    @TableField("product_status")
    private String productStatus;

    @TableField("author")
    private String author;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("publish_date")
    private Date publishDate;

    @TableField("publisher")
    private String publisher;

    @TableField("remark")
    private String remark;

//    @TableField(exist = false)
//    private String startTime;
//
//    @TableField(exist = false)
//    private String endTime;

}
