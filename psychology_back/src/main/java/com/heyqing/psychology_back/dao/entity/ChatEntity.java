package com.heyqing.psychology_back.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * ClassName:ChatEntity
 * Package:com.heyqing.psychology_back.dao.entity
 * Description:
 *
 * @Date:2024/3/18
 * @Author:Heyqing
 */
@Data
@TableName(value = "psy_chat")
public class ChatEntity {

    /**
     * 唯一标识
     */
    @TableId(value = "chat_id")
    private Long chatId;

    /**
     * id 0为自己其他为用户id
     */
    @TableField(value = "id")
    private Long id;

    /**
     * 信息实体
     */
    @TableField(value = "text")
    private String text;

    /**
     * 发送时间
     */
    @TableField(value = "date")
    private Date date;

}
