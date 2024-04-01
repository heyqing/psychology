package com.heyqing.psychology_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyqing.psychology_back.constant.ArticleTypeConstant;
import com.heyqing.psychology_back.dao.entity.ArticleEntity;
import com.heyqing.psychology_back.dao.mapper.ArticleMapper;
import com.heyqing.psychology_back.dao.po.PageSelectPO;
import com.heyqing.psychology_back.service.ArticleService;
import com.heyqing.psychology_back.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

/**
 * ClassName:ArticleServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public R getSwiper() {
        List<ArticleEntity> articleEntityList = selectArticle(ArticleTypeConstant.SWIPER);
        List<ArticleVO> resultList = copyList2Article(articleEntityList);
        return R.ok(resultList);
    }

    @Override
    public R getFloor(PageSelectPO pageSelectPO) {
        Page<ArticleEntity> page = new Page<>(pageSelectPO.getPageNum(),pageSelectPO.getPageSize());
        Page<ArticleEntity> pageResult = articleMapper.selectFloorPage(page,ArticleTypeConstant.FLOOR);
        List<ArticleEntity> articleEntityList = pageResult.getRecords();
        List<ArticleVO> resultList = copyList2Article(articleEntityList);
        return R.ok(resultList);
    }

    @Override
    public Long getBodyIdByArticleId(Long articleId) {
        try {
            ArticleEntity articleEntity = articleMapper.selectById(articleId);
            if (Objects.isNull(articleEntity)){
                return -1L;
            }
            Long bodyId = articleEntity.getDetailId();
            if (Objects.isNull(bodyId)){
                return -1L;
            }
            return bodyId;
        }catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    @Override
    public List<ArticleEntity> getArticleByArticleIdList(List<Long> articleIdList) {
        if (Objects.isNull(articleIdList)){
            return null;
        }
        List<ArticleEntity> resultList = new ArrayList<>();
        for (Long articleId : articleIdList) {
            ArticleEntity articleEntity = articleMapper.selectById(articleId);
            resultList.add(articleEntity);
        }
        return resultList;
    }

    /******************************************************private*********************************************/

    /**
     * 根据type查询article
     *
     * @param type
     * @return
     */
    private List<ArticleEntity> selectArticle(String type) {
        LambdaQueryWrapper<ArticleEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleEntity::getType, type);
        queryWrapper.select(ArticleEntity::getId, ArticleEntity::getTitle, ArticleEntity::getAvatar, ArticleEntity::getDetailId,ArticleEntity::getRefer);
        List<ArticleEntity> articleEntityList = articleMapper.selectList(queryWrapper);
        return articleEntityList;
    }

    /**
     * 拷贝文章实体
     *
     * @param articleEntity
     * @return
     */
    private ArticleVO copy2Article(ArticleEntity articleEntity) {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setId(String.valueOf(articleEntity.getId()));
        articleVO.setTitle(articleEntity.getTitle());
        articleVO.setAvatar(articleEntity.getAvatar());
        articleVO.setDetailId(String.valueOf(articleEntity.getDetailId()));
        articleVO.setRefer(articleEntity.getRefer());
        return articleVO;
    }

    /**
     * 拷贝文章实体列表
     *
     * @param articleEntityList
     * @return
     */
    private List<ArticleVO> copyList2Article(List<ArticleEntity> articleEntityList) {
        List<ArticleVO> articleVOList = new ArrayList<>();
        for (ArticleEntity articleEntity : articleEntityList) {
            articleVOList.add(copy2Article(articleEntity));
        }
        return articleVOList;
    }
}
