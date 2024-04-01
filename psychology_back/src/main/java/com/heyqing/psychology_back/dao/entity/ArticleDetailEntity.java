package com.heyqing.psychology_back.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * ClassName:ArticleDetailEntity
 * Package:com.heyqing.psychology_back.dao.entity
 * Description:
 *
 * @Date:2024/3/25
 * @Author:Heyqing
 */
@Data
@TableName("psy_article_detail")
public class ArticleDetailEntity {

    /**
     * 文章详情id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 文章内容
     */
    @TableField("body")
    private String body;

    /**
     * 文章内容HTML
     */
    @TableField("body_html")
    private String bodyHtml;

}
