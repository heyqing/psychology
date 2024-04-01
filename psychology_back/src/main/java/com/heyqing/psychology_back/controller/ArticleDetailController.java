package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.service.ArticleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ArticleDetailController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/25
 * @Author:Heyqing
 */
@RestController
@RequestMapping("article/detail")
public class ArticleDetailController {

    @Autowired
    private ArticleDetailService articleDetailService;

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    @GetMapping("{id}")
    public R getArticleDetail(@PathVariable("id") Long articleId){
        return articleDetailService.getArticleDetail(articleId);
    }
}
