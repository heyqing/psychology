package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * ClassName:TreeTopicService
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/27
 * @Author:Heyqing
 */
public interface TreeTopicService {

    /**
     * 获取话题
     *
     * @return
     */
    R getAllTopic();

    /**
     * 搜索话题
     *
     * @param query
     * @return
     */
    R searchTopic(String query);
}
