package com.heyqing.psychology_back.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.entity.ArticleDetailEntity;
import com.heyqing.psychology_back.dao.mapper.ArticleDetailMapper;
import com.heyqing.psychology_back.service.ArticleDetailService;
import com.heyqing.psychology_back.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * ClassName:ArticleDetailServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/25
 * @Author:Heyqing
 */
@Service
public class ArticleDetailServiceImpl implements ArticleDetailService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleDetailMapper articleDetailMapper;

    @Override
    public R getArticleDetail(Long articleId) {
        try {
            Long bodyId = articleService.getBodyIdByArticleId(articleId);
            ArticleDetailEntity articleDetailEntity = articleDetailMapper.selectById(bodyId);
            if (Objects.isNull(articleDetailEntity)){
                return R.failed("查询失败");
            }
            return R.ok(articleDetailEntity);
        }catch (Exception e) {
            e.printStackTrace();
            return R.failed("查询失败");
        }
    }

    /************************************************************private***************************************************************/
}
