package com.heyqing.psychology_back.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName:TreeMsgEntity
 * Package:com.heyqing.psychology_back.dao.entity
 * Description:
 *
 * @Date:2024/3/29
 * @Author:Heyqing
 */
@Data
@TableName(value = "psy_tree_msg")
public class TreeMsgEntity {

    /**
     * 留言id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 留言内容
     */
    @TableField(value = "msg")
    private String msg;

    /**
     * 回复
     */
    @TableField(value = "reply")
    private String reply;

    /**
     * 回复id
     */
    @TableField(value = "reply_id")
    private Long replyId;

    /**
     * 回复id
     */
    @TableField(value = "send_id")
    private Long sendId;

}
