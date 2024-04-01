package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.ChatSaveMsgPO;
import com.heyqing.psychology_back.dao.po.PageParamPO;
import com.heyqing.psychology_back.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:ChatController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/18
 * @Author:Heyqing
 */
@RestController
@RequestMapping("chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    /**
     * 查询；聊天记录
     *
     * @param pageParamPO
     * @return
     */
    @PostMapping("list")
    public R getList(@RequestBody PageParamPO pageParamPO) {
        return chatService.getList(pageParamPO);
    }

    /**
     * 保存信息
     *
     * @param chatSaveMsgPO
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody ChatSaveMsgPO chatSaveMsgPO) {
        return chatService.save(chatSaveMsgPO);
    }
}
