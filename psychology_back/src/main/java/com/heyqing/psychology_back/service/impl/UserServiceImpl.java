package com.heyqing.psychology_back.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.constant.SystemConstant;
import com.heyqing.psychology_back.dao.entity.ArticleEntity;
import com.heyqing.psychology_back.dao.entity.UserEntity;
import com.heyqing.psychology_back.dao.mapper.UserMapper;
import com.heyqing.psychology_back.dao.po.LoginPO;
import com.heyqing.psychology_back.properties.WeiXinProperties;
import com.heyqing.psychology_back.service.ArticleService;
import com.heyqing.psychology_back.service.UserService;
import com.heyqing.psychology_back.utils.HttpClientUtil;
import com.heyqing.psychology_back.utils.IdUtil;
import com.heyqing.psychology_back.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * ClassName:UserServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/11
 * @Author:Heyqing
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private WeiXinProperties weiXinProperties;
    @Autowired
    private HttpClientUtil httpClientUtil;

    /**
     * 用户登录
     *
     * @param loginPO
     * @return
     */
    @Override
    public R login(LoginPO loginPO) {
        //获取openid
        String jscode2sessionUrl=weiXinProperties.getJscode2sessionUrl()+"?appid="+weiXinProperties.getAppid()+"&secret="+weiXinProperties.getSecret()+"&js_code="+loginPO.getCode()+"&grant_type=authorization_code";
        String result = httpClientUtil.sendHttpGet(jscode2sessionUrl);
        JSONObject jsonObject = JSON.parseObject(result);
        String openid = jsonObject.get("openid").toString();
        //查找用户
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("openid",openid);
        UserEntity userEntity = userMapper.selectOne(queryWrapper);
        //判断是否存在
        if (Objects.isNull(userEntity)){
            //不存在,插入新用户
            userEntity = new UserEntity();
            userEntity.setId(IdUtil.getCurrentId());
            userEntity.setOpenid(openid);
            userEntity.setCreateTime(new Date());
            userEntity.setLastTime(new Date());
            userEntity.setNickname(loginPO.getNickName());
            userEntity.setAvatarUrl(loginPO.getAvatarUrl());
            userMapper.insert(userEntity);
        }else {
            //存在
            userEntity.setLastTime(new Date());
            userEntity.setNickname(loginPO.getNickName());
            userEntity.setAvatarUrl(loginPO.getAvatarUrl());
            userMapper.updateById(userEntity);
        }
        String token = JwtUtil.createJWT(openid,loginPO.getNickName(), SystemConstant.JWT_TTL);
        return R.ok(token);
    }

    @Override
    public R getLikeArticle(List<Long> articleIdList) {
        //委托ArticleService完成
        List<ArticleEntity> articleEntityList = articleService.getArticleByArticleIdList(articleIdList);
        return R.ok(articleEntityList);
    }


    @Override
    public R getUserInfo(Long userId) {
        try {
            LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserEntity::getId,userId);
            queryWrapper.select(UserEntity::getNickname,UserEntity::getAvatarUrl);
            UserEntity userEntity = userMapper.selectOne(queryWrapper);
            if (Objects.isNull(userEntity)){
                return R.failed("出错了");
            }
            return R.ok(userEntity);
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("出错了");
        }
    }
}
