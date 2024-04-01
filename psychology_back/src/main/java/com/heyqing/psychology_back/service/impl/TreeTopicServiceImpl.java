package com.heyqing.psychology_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.entity.TreeTopicEntity;
import com.heyqing.psychology_back.dao.mapper.TreeTopicMapper;
import com.heyqing.psychology_back.service.TreeTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:TreeTopicServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/27
 * @Author:Heyqing
 */
@Service
public class TreeTopicServiceImpl implements TreeTopicService {

    @Autowired
    private TreeTopicMapper treeTopicMapper;

    @Override
    public R getAllTopic() {
        LambdaQueryWrapper<TreeTopicEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(TreeTopicEntity::getId,TreeTopicEntity::getContent,TreeTopicEntity::getMid);
        List<TreeTopicEntity> treeTopicEntityList = treeTopicMapper.selectList(queryWrapper);
        return R.ok(treeTopicEntityList);
    }

    @Override
    public R searchTopic(String query) {
        LambdaQueryWrapper<TreeTopicEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(TreeTopicEntity::getContent,query);
        List<TreeTopicEntity> treeTopicEntityList = treeTopicMapper.selectList(queryWrapper);
        return R.ok(treeTopicEntityList);
    }

    /******************************************private****************************************/
}
