package com.heyqing.psychology_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.entity.TreeMsgEntity;
import com.heyqing.psychology_back.dao.mapper.TreeMsgMapper;
import com.heyqing.psychology_back.dao.po.TreeWriteMsgPO;
import com.heyqing.psychology_back.service.TreeMsgService;
import com.heyqing.psychology_back.utils.IdUtil;
import com.heyqing.psychology_back.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:TreeMsgServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/29
 * @Author:Heyqing
 */
@Service
public class TreeMsgServiceImpl implements TreeMsgService {

    @Autowired
    private TreeMsgMapper treeMsgMapper;

    @Override
    public R writeMsg(TreeWriteMsgPO treeWriteMsgPO) {
        if(Strings.isBlank(treeWriteMsgPO.getContent())){
            return R.failed("存入失败");
        }
        String content = treeWriteMsgPO.getContent();
        TreeMsgEntity treeMsgEntity = new TreeMsgEntity();
        treeMsgEntity.setId(IdUtil.getCurrentId());
        treeMsgEntity.setMsg(content);
        try{
            treeMsgMapper.insert(treeMsgEntity);
            return R.ok("success");
        }catch (Exception e){
            e.printStackTrace();
            return R.failed("存入失败");
        }
    }

    @Override
    public R showMsg() {
        LambdaQueryWrapper<TreeMsgEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(TreeMsgEntity::getId,TreeMsgEntity::getMsg);
        List<TreeMsgEntity> treeMsgEntities = treeMsgMapper.selectList(queryWrapper);
        return R.ok(treeMsgEntities);
    }

    @Override
    public R replyMsg() {
        LambdaQueryWrapper<TreeMsgEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(TreeMsgEntity::getReplyId,TreeMsgEntity::getReply);
        List<TreeMsgEntity> treeMsgEntities = treeMsgMapper.selectList(queryWrapper);
        for (TreeMsgEntity treeMsgEntity : treeMsgEntities) {
            if (!Strings.isBlank(treeMsgEntity.getReply()) || !treeMsgEntity.getReplyId().equals(-999L)){
                return R.ok(treeMsgEntities);
            }
        }
        return R.failed("暂无回复");
    }
    /*********************************************************private*************************************************/
}
