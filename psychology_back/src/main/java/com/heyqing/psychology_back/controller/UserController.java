package com.heyqing.psychology_back.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.LoginPO;
import com.heyqing.psychology_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:UserController
 * Package:com.heyqing.psychology_back.controller
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param loginPO
     * @return
     */
    @PostMapping("login")
    public R login(@RequestBody LoginPO loginPO) {
        return userService.login(loginPO);
    }

    /**
     * 获取喜欢文章
     *
     * @param ArticleIdList
     * @return
     */
    @PostMapping("like")
    public R getLikeArticle(@RequestBody List<Long> ArticleIdList) {
        return userService.getLikeArticle(ArticleIdList);
    }

}
