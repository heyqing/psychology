package com.heyqing.psychology_back.vo;

import lombok.Data;

/**
 * ClassName:VideoVO
 * Package:com.heyqing.psychology_back.vo
 * Description:
 *
 * @Date:2024/3/4
 * @Author:Heyqing
 */
@Data
public class VideoVO {

    /**
     * 视频id
     */
    private String id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频链接
     */
    private String link;
}
