package com.heyqing.psychology_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.heyqing.psychology_back.constant.ArticleTypeConstant;
import com.heyqing.psychology_back.dao.entity.ArticleEntity;
import com.heyqing.psychology_back.dao.entity.VideoEntity;
import com.heyqing.psychology_back.dao.mapper.VideoMapper;
import com.heyqing.psychology_back.dao.po.PageSelectPO;
import com.heyqing.psychology_back.service.VideoService;
import com.heyqing.psychology_back.vo.ArticleVO;
import com.heyqing.psychology_back.vo.VideoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:VideoServiceImpl
 * Package:com.heyqing.psychology_back.service.impl
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public R getVideo(PageSelectPO pageSelectPO) {
        Page<VideoEntity> page = new Page<>(pageSelectPO.getPageNum(), pageSelectPO.getPageSize());
        LambdaQueryWrapper<VideoEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(VideoEntity::getId, VideoEntity::getTitle, VideoEntity::getLink);
        Page<VideoEntity> pageResult = videoMapper.selectPage(page, queryWrapper);
        List<VideoEntity> videoEntityList = pageResult.getRecords();
        List<VideoVO> resultList = copyList2Video(videoEntityList);
        return R.ok(resultList);
    }


    /***************************************private***************************************/

    /**
     * 拷贝video实体
     *
     * @param videoEntity
     * @return
     */
    private VideoVO copy2Video(VideoEntity videoEntity) {
        VideoVO videoVO = new VideoVO();
        videoVO.setId(String.valueOf(videoEntity.getId()));
        videoVO.setTitle(videoEntity.getTitle());
        videoVO.setLink(videoEntity.getLink());
        return videoVO;
    }

    /**
     * 拷贝video
     *
     * @param videoEntityList
     * @return
     */
    private List<VideoVO> copyList2Video(List<VideoEntity> videoEntityList) {
        List<VideoVO> videoVOList = new ArrayList<>();
        for (VideoEntity videoEntity : videoEntityList) {
            videoVOList.add(copy2Video(videoEntity));
        }
        return videoVOList;
    }
}
