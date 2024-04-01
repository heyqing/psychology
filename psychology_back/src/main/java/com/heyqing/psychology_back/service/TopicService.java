package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.GetAnswerPO;

/**
 * ClassName:TopicService
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/21
 * @Author:Heyqing
 */
public interface TopicService {

    /**
     * 获取题目
     *
     * @param topicId
     * @return
     */
    R getTopic(Long topicId);

    /**
     * 获取选项
     *
     * @param optionId
     * @return
     */
    R getOption(Long optionId);

    /**
     * 获取答案
     *
     * @param answerPO
     * @return
     */
    R getAnswer(GetAnswerPO answerPO);
}
