package com.heyqing.psychology_back.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName:TreeTopicEntity
 * Package:com.heyqing.psychology_back.dao.entity
 * Description:
 *
 * @Date:2024/3/27
 * @Author:Heyqing
 */
@Data
@TableName(value = "psy_tree_topic")
public class TreeTopicEntity {

    /**
     * 话题Id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 话题详情id
     */
    @TableField(value = "mid")
    private Long mid;
}
