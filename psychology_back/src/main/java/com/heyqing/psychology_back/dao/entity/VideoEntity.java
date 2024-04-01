package com.heyqing.psychology_back.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * ClassName:VideoEntity
 * Package:com.heyqing.psychology_back.dao.entity
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@Data
@TableName(value = "psy_video")
public class VideoEntity {

    /**
     * 视频id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 视频标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 视频链接
     */
    @TableField(value = "link")
    private String link;

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
