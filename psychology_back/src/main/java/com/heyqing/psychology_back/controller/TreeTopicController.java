package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.service.TreeTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:TreeTopicController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/27
 * @Author:Heyqing
 */
@RestController
@RequestMapping("tree")
public class TreeTopicController {

    @Autowired
    private TreeTopicService treeTopicService;

    /**
     * 获取话题
     *
     * @return
     */
    @GetMapping("topic")
    public R getAllTopic() {
        return treeTopicService.getAllTopic();
    }

    /**
     * 搜索话题
     *
     * @param query
     * @return
     */
    @PostMapping("search")
    public R searchTopic(@RequestBody String query) {
        return treeTopicService.searchTopic(query);
    }


}
