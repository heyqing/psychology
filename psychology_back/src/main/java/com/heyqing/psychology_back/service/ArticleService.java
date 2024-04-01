package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.entity.ArticleEntity;
import com.heyqing.psychology_back.dao.po.PageSelectPO;

import java.util.List;

/**
 * ClassName:ArticleService
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
public interface ArticleService {

    /**
     * 获取轮播图
     *
     * @return
     */
    R getSwiper();

    /**
     * 获取楼层
     *
     * @param pageSelectPO
     * @return
     */
    R getFloor(PageSelectPO pageSelectPO);

    /**
     * 获取bodyId
     *
     * @param articleId
     * @return
     */
    Long getBodyIdByArticleId(Long articleId);

    /**
     * 获取文章idList
     *
     * @param articleIdList
     */
    List<ArticleEntity> getArticleByArticleIdList(List<Long> articleIdList);
}
