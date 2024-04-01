package com.heyqing.psychology_back.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.heyqing.psychology_back.dao.po.GetAnswerPO;
import com.heyqing.psychology_back.service.TopicService;
import com.heyqing.psychology_back.utils.tool.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:TopicServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/21
 * @Author:Heyqing
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepo topicRepo;

    @Override
    public R getTopic(Long topicId){
        List<String> resultList = null;
        if (topicId == 0) {
            resultList = topicRepo.getPSTRTopicList();
        } else if (topicId == 1) {
            resultList = topicRepo.getCDITopicList();
        } else if (topicId == 2) {
            resultList = topicRepo.getMSSMHSTopicList();
        } else if (topicId == 3) {
            resultList = topicRepo.getEISTopicList();
        } else if (topicId == 4) {
            resultList = topicRepo.getPTopicList();
        } else if (topicId == 5) {
            resultList = topicRepo.getLTopicList();
        }
        return R.ok(resultList);

    }

    @Override
    public R getOption(Long optionId) {
        List<Object> resultList = null;
        if (optionId == 0) {
            resultList = topicRepo.getPSTROptionList();
        } else if (optionId == 1) {
            resultList = topicRepo.getCDIOptionList();
        } else if (optionId == 2) {
            resultList = topicRepo.getMSSMHSOptionList();
        } else if (optionId == 3) {
            resultList = topicRepo.getEISOptionList();
        } else if (optionId == 4) {
            resultList = topicRepo.getPOptionList();
        } else if (optionId == 5) {
            resultList = topicRepo.getLOptionList();
        }
        return R.ok(resultList);
    }

    @Override
    public R getAnswer(GetAnswerPO answerPO) {

        Integer id = answerPO.getId();
        Integer answer = answerPO.getTotal();
        Map<String,Object> resultAnswer = null;
        if (id == 0) {
            resultAnswer = topicRepo.getPSTRAnswer(answer);
        } else if (id == 1) {
            resultAnswer = topicRepo.getCDIAnswer(answer);
        } else if (id == 2) {
            resultAnswer = topicRepo.getMSSMHSAnswer(answer);
        } else if (id == 3) {
            resultAnswer = topicRepo.getEISAnswer(answer);
        } else if (id == 4) {
            resultAnswer = topicRepo.getPAnswer(answer);
        } else if (id == 5) {
            resultAnswer = topicRepo.getLAnswer(answer);
        }
        return R.ok(resultAnswer);
    }

    /*****************************************private********************************************/
}
