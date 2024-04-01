package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * ClassName:ArticleDetailService
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/25
 * @Author:Heyqing
 */
public interface ArticleDetailService {

    /**
     * 获取文章详情
     *
     * @param articleId
     * @return
     */
    R getArticleDetail(Long articleId);
}
