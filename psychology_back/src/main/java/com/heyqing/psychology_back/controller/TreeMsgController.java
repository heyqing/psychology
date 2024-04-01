package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.TreeWriteMsgPO;
import com.heyqing.psychology_back.service.TreeMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:TreeMsgController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/29
 * @Author:Heyqing
 */
@RestController
@RequestMapping("tree/msg")
public class TreeMsgController {

    @Autowired
    private TreeMsgService treeMsgService;

    /**
     * 写入留言
     *
     * @param treeWriteMsgPO
     * @return
     */
    @PostMapping("write")
    public R writeMsg(@RequestBody TreeWriteMsgPO treeWriteMsgPO) {
        return treeMsgService.writeMsg(treeWriteMsgPO);
    }

    /**
     * 查看我的留言
     *
     * @return
     */
    @GetMapping("show")
    public R showMsg() {
        return treeMsgService.showMsg();
    }

    /**
     * 我的回复
     *
     * @return
     */
    @GetMapping("reply")
    public R replyMsg() {
        return treeMsgService.replyMsg();
    }
}
