package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * ClassName:TreeTopicDetailService
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/28
 * @Author:Heyqing
 */
public interface TreeTopicDetailService {

    /**
     * 获取话题详情
     *
     * @param topicDetailId
     * @return
     */
    R getTopicEntity(Long topicDetailId);

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    R getUser(Long userId);
}
