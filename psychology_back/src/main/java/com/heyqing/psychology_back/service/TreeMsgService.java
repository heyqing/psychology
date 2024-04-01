package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.TreeWriteMsgPO;

/**
 * ClassName:TreeMsgService
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/29
 * @Author:Heyqing
 */
public interface TreeMsgService {

    /**
     * 写入留言
     *
     * @param treeWriteMsgPO
     * @return
     */
    R writeMsg(TreeWriteMsgPO treeWriteMsgPO);

    /**
     * 查看我的留言
     *
     * @return
     */
    R showMsg();

    /**
     * 我的回复
     *
     * @return
     */
    R replyMsg();
}
