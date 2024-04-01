package com.heyqing.psychology_back.dao.po;

import lombok.Data;

/**
 * ClassName:PageSelectPO
 * Package:com.heyqing.psychology_back.dao.po
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@Data
public class PageSelectPO {
    /**
     * 查询页数
     */
    private Integer pageNum;
    /**
     * 查询数量
     */
    private Integer pageSize;

}
