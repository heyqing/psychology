package com.heyqing.psychology_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyqing.psychology_back.dao.entity.ChatEntity;
import com.heyqing.psychology_back.dao.mapper.ChatMapper;
import com.heyqing.psychology_back.dao.po.ChatSaveMsgPO;
import com.heyqing.psychology_back.dao.po.PageParamPO;
import com.heyqing.psychology_back.service.ChatService;
import com.heyqing.psychology_back.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ChatServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/18
 * @Author:Heyqing
 */
@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public R getList(PageParamPO pageParamPO) {


        log.info(String.valueOf(pageParamPO));


        Page<ChatEntity> page = new Page<>(pageParamPO.getPageNum(), pageParamPO.getPageSize());
        LambdaQueryWrapper<ChatEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(ChatEntity::getDate);
        Page<ChatEntity> pageResult = chatMapper.selectPage(page, queryWrapper);
        List<ChatEntity> content = pageResult.getRecords();
        return R.ok(content);
    }

    @Override
    public R save(ChatSaveMsgPO chatSaveMsgPO) {
        log.info(String.valueOf(chatSaveMsgPO));
        if (Strings.isBlank(chatSaveMsgPO.getText())){
            return R.failed("");
        }
        try {
            ChatEntity chatEntity = new ChatEntity();

            chatEntity.setChatId(IdUtil.getCurrentId());
            chatEntity.setId(chatSaveMsgPO.getId());
            chatEntity.setText(chatSaveMsgPO.getText());
            chatEntity.setDate(chatSaveMsgPO.getDate());
            chatMapper.insert(chatEntity);
            List<ChatEntity> resultList = new ArrayList<>();
            resultList.add(chatEntity);
            return R.ok(resultList);
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed("发送失败");
        }
    }

    /***************************************private******************************************/
}
