package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.service.TreeTopicDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:TreeTopicDetailController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/28
 * @Author:Heyqing
 */
@RestController
@RequestMapping("tree/topic/detail")
public class TreeTopicDetailController {

    @Autowired
    private TreeTopicDetailService treeTopicDetailService;

    /**
     * 获取话题详情
     *
     * @param topicDetailId
     * @return
     */
    @GetMapping("{id}")
    public R getTopicEntity(@PathVariable("id") Long topicDetailId) {
        return treeTopicDetailService.getTopicEntity(topicDetailId);
    }

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("getUser/{id}")
    public R getUser(@PathVariable("id") Long userId) {
        return treeTopicDetailService.getUser(userId);
    }
}
