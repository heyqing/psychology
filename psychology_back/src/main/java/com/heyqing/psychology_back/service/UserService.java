package com.heyqing.psychology_back.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.LoginPO;

import java.util.List;

/**
 * ClassName:UserService
 * Package:com.heyqing.psychology_back.service
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param loginPO
     * @return
     */
    R login(LoginPO loginPO);

    /**
     * 获取喜欢文章
     *
     * @param articleIdList
     * @return
     */
    R getLikeArticle(List<Long> articleIdList);

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    R getUserInfo(Long userId);
}
