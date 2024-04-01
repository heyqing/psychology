package com.heyqing.psychology_back.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.entity.TreeTopicDetailEntity;
import com.heyqing.psychology_back.dao.mapper.TreeTopicDetailMapper;
import com.heyqing.psychology_back.service.TreeTopicDetailService;
import com.heyqing.psychology_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * ClassName:TreeTopicDetailServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/28
 * @Author:Heyqing
 */
@Service
public class TreeTopicDetailServiceImpl implements TreeTopicDetailService {

    @Autowired
    private TreeTopicDetailMapper treeTopicDetailMapper;
    @Autowired
    private UserService userService;

    @Override
    public R getTopicEntity(Long topicDetailId) {
        try{
            TreeTopicDetailEntity treeTopicDetailEntity = treeTopicDetailMapper.selectById(topicDetailId);
            if (Objects.isNull(treeTopicDetailEntity)){
                return R.failed("没有该话题");
            }
            return R.ok(treeTopicDetailEntity);
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("出错了");
        }
    }

    @Override
    public R getUser(Long userId) {
        //委托给UserService实现
        return userService.getUserInfo(userId);
    }

    /***************************************private************************************************/
}
