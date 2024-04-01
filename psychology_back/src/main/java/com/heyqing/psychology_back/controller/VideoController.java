package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.PageSelectPO;
import com.heyqing.psychology_back.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:VideoController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@RestController
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 获取首页视频
     *
     * @param pageSelectPO
     * @return
     */
    @PostMapping("list")
    public R getVideo(@RequestBody PageSelectPO pageSelectPO) {
        return videoService.getVideo(pageSelectPO);
    }
}
