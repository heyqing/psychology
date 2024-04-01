package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.GetAnswerPO;
import com.heyqing.psychology_back.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:TopicController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/21
 * @Author:Heyqing
 */
@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * 获取题目
     *
     * @param topicId
     * @return
     */
    @GetMapping("/{id}")
    public R getTopic(@PathVariable("id") Long topicId) {
        return topicService.getTopic(topicId);
    }

    /**
     * 获取选项
     *
     * @param optionId
     * @return
     */
    @GetMapping("option/{id}")
    public R getOption(@PathVariable("id") Long optionId) {
        return topicService.getOption(optionId);
    }

    /**
     * 获取答案
     *
     * @param answerPO
     * @return
     */
    @PostMapping("answer")
    public R getAnswer(@RequestBody GetAnswerPO answerPO) {
        return topicService.getAnswer(answerPO);
    }


}
