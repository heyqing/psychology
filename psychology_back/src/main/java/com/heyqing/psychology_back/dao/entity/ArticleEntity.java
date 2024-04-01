package com.heyqing.psychology_back.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * ClassName:ArticleEntity
 * Package:com.heyqing.psychology_back.dao.entity
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@Data
@TableName(value = "psy_article")
public class ArticleEntity {

    /**
     * 文章id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 文章标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 文章描述
     */
    @TableField(value = "refer")
    private String refer;

    /**
     * 文章图片
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 文章类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 文章详情id
     */
    @TableField(value = "detail_id")
    private Long detailId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
}
