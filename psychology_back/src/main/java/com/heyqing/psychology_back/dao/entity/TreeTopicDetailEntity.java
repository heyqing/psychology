package com.heyqing.psychology_back.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName:TreeTopicDetailEntity
 * Package:com.heyqing.psychology_back.dao.entity
 * Description:
 *
 * @Date:2024/3/28
 * @Author:Heyqing
 */
@Data
@TableName(value = "psy_tree_topic_detail")
public class TreeTopicDetailEntity {

    /**
     * 话题详情id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 是否匿名 0否 1是
     */
    @TableField(value = "type")
    private Integer type;

}
