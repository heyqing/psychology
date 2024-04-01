package com.heyqing.psychology_back.vo;

import lombok.Data;

/**
 * ClassName:ArticleSwiperVO
 * Package:com.heyqing.psychology_back.vo
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@Data
public class ArticleVO {

    /**
     * 文章id
     */
    private String id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章描述
     */
    private String refer;

    /**
     * 文章图片
     */
    private String avatar;

    /**
     * 文章详情id
     */
    private String detailId;
}
