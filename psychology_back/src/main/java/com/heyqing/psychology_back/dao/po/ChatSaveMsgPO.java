package com.heyqing.psychology_back.dao.po;

import lombok.Data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * ClassName:ChatSaveMsgPO
 * Package:com.heyqing.psychology_back.dao.po
 * Description:
 *
 * @Date:2024/3/18
 * @Author:Heyqing
 */
@Data
public class ChatSaveMsgPO {
    /**
     * 自身id 0
     */
    private Long id;

    /**
     * 信息内容
     */
    private String text;

    /**
     * 发送时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
