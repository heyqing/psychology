package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.PageSelectPO;

/**
 * ClassName:VideoService
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
public interface VideoService {

    /**
     * 获取首页视频
     *
     * @param pageSelectPO
     * @return
     */
    R getVideo(PageSelectPO pageSelectPO);
}
