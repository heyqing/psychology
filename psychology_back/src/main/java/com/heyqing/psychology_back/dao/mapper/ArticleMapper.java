package com.heyqing.psychology_back.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyqing.psychology_back.dao.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:ArticleMapper
 * Package:com.heyqing.psychology_back.dao.mapper
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {
    /**
     * 查询首页楼层
     *
     * @param page
     * @param floor
     * @return
     */
    Page<ArticleEntity> selectFloorPage(Page<ArticleEntity> page, String floor);
}
