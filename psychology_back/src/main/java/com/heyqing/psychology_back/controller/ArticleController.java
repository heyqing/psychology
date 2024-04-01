package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.PageSelectPO;
import com.heyqing.psychology_back.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:ArticleController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取首页轮播图
     *
     * @return
     */
    @GetMapping("swiper")
    public R getSwiper() {
        return articleService.getSwiper();
    }

    /**
     * 获取首页楼层
     *
     * @param pageSelectPO
     * @return
     */
    @PostMapping("floor")
    public R getFloor(@RequestBody PageSelectPO pageSelectPO) {
        return articleService.getFloor(pageSelectPO);
    }
}
