package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.ChatSaveMsgPO;
import com.heyqing.psychology_back.dao.po.PageParamPO;

/**
 * ClassName:ChatXervice
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/18
 * @Author:Heyqing
 */
public interface ChatService {

    /**
     * 获取聊天信息
     *
     * @param pageParamPO
     * @return
     */
    R getList(PageParamPO pageParamPO);

    /**
     * 保存信息
     *
     * @param chatSaveMsgPO
     * @return
     */
    R save(ChatSaveMsgPO chatSaveMsgPO);
}
