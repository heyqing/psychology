package com.heyqing.psychology_back.dao.po;

import lombok.Data;

/**
 * ClassName:PageParamPO
 * Package:com.heyqing.psychology_back.dao.po
 * Description:
 *
 * @Date:2024/3/18
 * @Author:Heyqing
 */
@Data
public class PageParamPO {

    /**
     * 聊天对象id
     */
    private Long id;

    /**
     * 查询页数
     */
    private Integer pageNum;
    /**
     * 查询数量
     */
    private Integer pageSize;

}
